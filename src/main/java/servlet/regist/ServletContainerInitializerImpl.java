package servlet.regist;

import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;

import jakarta.servlet.DispatcherType;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterRegistration;
import jakarta.servlet.ServletContainerInitializer;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HandlesTypes;

@HandlesTypes({RegistrationFilter.class, RegistrationServlet.class}) 
public class ServletContainerInitializerImpl implements ServletContainerInitializer {

	@Override
	public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
		
		System.out.println("ServletContainerInitializer.onStartup called!!!");
		
		String isHandlesTypes = ctx.getInitParameter("handlesTypes");
		String addFilter = ctx.getInitParameter("addFilter");
		String addServlet = ctx.getInitParameter("addServlet");
		if(isHandlesTypes.equalsIgnoreCase("true")) {
			System.out.println("filter and servlet annotated by HandlesTypes would be registered!");
			System.out.println("by how to add filter or servlet: filter(" + addFilter + "), servlet(" + addServlet + ")");
			if(c != null) {
				Iterator<Class<?>> it = c.iterator();
				while(it.hasNext()) {
					Class<?> clazz = it.next();
					System.out.println(clazz.getName());
					if(clazz.isAssignableFrom(RegistrationFilter.class)) {
						FilterRegistration.Dynamic fd = null;
						String filterName = "handlesTypesFilter";
						if(addFilter.equalsIgnoreCase("filterClass")) {
							fd = ctx.addFilter(filterName,(Class<? extends Filter>)clazz);
						}else if(addFilter.equalsIgnoreCase("filter")) {
							Filter f = ctx.createFilter((Class<Filter>) clazz);
							fd = ctx.addFilter(filterName, f);
						}else{
							fd = ctx.addFilter(filterName, clazz.getName());
						}
						fd.setInitParameter("filter", "HandlesTypes");
						fd.setAsyncSupported(false);
						EnumSet<DispatcherType> set = EnumSet.of(DispatcherType.REQUEST);
						fd.addMappingForServletNames(set, false, "registrationTest");
						fd.addMappingForUrlPatterns(set, true, "/registrationTest");
					}else if(clazz.isAssignableFrom(RegistrationServlet.class)) {
						
					}
				}
			}
		}
		
	/*
		if(c != null) {
			for(Class clazz : c) {
				if(clazz != null)
					System.out.println(clazz.getName());
			}
		}
		if(addFilter.equalsIgnoreCase("filterClass")) {
			
		}else if(addFilter.equalsIgnoreCase("filter")) {
			
		}else{
			
		}
		
		//TestServlet1 servlet = new TestServlet1();
		//ServletRegistration.Dynamic sd = ctx.addServlet("testServlet1", servlet);
		//sd.addMapping("/testServlet1");
		//sd.setLoadOnStartup(1);
		*/

	}

}
