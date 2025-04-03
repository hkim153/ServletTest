<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<input id="file" type="file">
	<input id="connect" type="button" value="connect">
	<input id="send" type="button" value="send">
</body>
<script type="text/javascript">
	var ws = null;

	function connector() {

		var url = "ws://localhost:9191/ServletTest/webSocketFileUpload";
		ws = new WebSocket(url);
		ws.binaryType = "arraybuffer";
		ws.onopen = function() {
			alert("연결 완료");
		};

		ws.onmessage = function(e) {
			alert(e.msg);
		};

		ws.onclose = function() {
			alert("연결 종료");
		};
		ws.onerror = function(e) {
			alert(e.msg);
		}
	}

	 function sendFile() {
         var file = document.getElementById('filename').files[0];
         ws.send('filename:'+file.name);
         var reader = new FileReader();
         var rawData = new ArrayBuffer();            

         var fStart = 0; //start byte
         var fEnd = 1024*1024; //packet size & end byte when slicing file.
         var fileFrag; //file fragment                       

         reader.loadend = function() {           
             console.log('load end');
         }

         reader.onload = function(e) {
             if(e.target.readyState == FileReader.DONE) {
                 rawData = e.target.result;              
                 //var blob = new Blob([rawData]);           
                 ws.send(rawData);   
             }               
         }

         fileFrag = file.slice(fStart, fEnd);
         reader.readAsArrayBuffer(fileFrag);         

         objRun = setInterval(function() {               
             if (ws.bufferedAmount == 0) {                   
                 if(reader.readyState == FileReader.DONE) {                      
                     if(fStart<file.size) {                          
                         fStart = fEnd + 1;
                         fEnd = fStart + 1024*1024;
                         fileFrag = file.slice(fStart, fEnd);
                         console.log('fileFrag Size: ' + fileFrag.size + 'Frag End: ' + fEnd);
                         reader.readAsArrayBuffer(fileFrag); 
                     } else clearInterval(objRun);
                 } //end of readyState
             } //end of ws.buffer
         }, 5);//end of setInterval      
     }//end of sendFile()    

	function addEvent() {
		document.getElementById("connect").addEventListener("click", connector,
				false);
		document.getElementById("send").addEventListener("click", sendFile,
				false);
	}

	window.addEventListener("load", addEvent, false);
</script>
</html>