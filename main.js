function showComposeBox()
{
    
    var appendComposeContent="<br /><br /><div id=\"newMail\"> <form action=\"comp\" name=\"compose\">    <input type=\"submit\" id=\"send1\" name=\"send1\" value=\"Send Mail\"/><br /> <input type=\"text\" id=\"newSender\" name=\"newSender\" />                       To&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type=\"text\" id=\"newReceiver\" name=\"newReceiver\"/>";
    appendComposeContent+="<br /><br />Subject&nbsp&nbsp&nbsp<input type=\"text\" id=\"newSubject\" name=\"newSubject\"/>";
    appendComposeContent+="<hr /><br />Message&nbsp&nbsp&nbsp<br /><textarea id=\"newMessage\" name=\"newMessage\" rows=\"20\" cols=\"100\"></textarea></form></div>";
	       
	
    document.getElementById("mainDiv").innerHTML=appendComposeContent;
	document.getElementById('newSender').style.display="none";
	
	
	
	
}
function showInbox()
{ alert("pou");
  response.sendRedirect("in");
   
}
function showDrafts()
{
    var appendDraftsContent="<br /><br /><ul id=\"messages\">";
    appendDraftsContent+="<li id=\"message1\" class=\"message\" onclick=\"showMessage(ssender1.innerHTML,subject1.innerHTML,\"drafts\")\">";
    appendDraftsContent+="<span id=\"sender1\" class=\"sender\">Niveditha</span>";
    appendDraftsContent+="<span id=\"subject1\" class=\"subject\">Pragyan</span>";
    appendDraftsContent+="<span id=\"date1\" class=\"date\">Jan 12</span>";
    appendDraftsContent+="</li>";
    appendDraftsContent+="<li id=\"message2\" class=\"message\" onclick=\"showMessage(ssender1.innerHTML,subject1.innerHTML,\"drafts\")\">";
    appendDraftsContent+="<span id=\"sender2\" class=\"sender\">Hari</span>";
    appendDraftsContent+="<span id=\"subject2\" class=\"subject\">facebook</span>";
    appendDraftsContent+="<span id=\"date2\" class=\"date\">Jan 12</span>";
    appendDraftsContent+="</li>";
    appendDraftsContent+="<li id=\"message3\" class=\"message\" onclick=\"showMessage(ssender1.innerHTML,subject1.innerHTML,\"drafts\")\">";
    appendDraftsContent+="<span id=\"sender3\" class=\"sender\">Siddharth</span>";
    appendDraftsContent+="<span id=\"subject3\" class=\"subject\">ACM</span>";
    appendDraftsContent+="<span id=\"date3\" class=\"date\">Jan 11</span>";
    appendDraftsContent+="</li>";
    appendDraftsContent+="<li id=\"message4\" class=\"message\" onclick=\"showMessage(ssender1.innerHTML,subject1.innerHTML,\"drafts\")\">";
    appendDraftsContent+="<span id=\"sender4\" class=\"sender\">Subash</span>";
    appendDraftsContent+="<span id=\"subject4\" class=\"subject\">bike</span>";
    appendDraftsContent+="<span id=\"date4\" class=\"date\">Jan 10</span>";
    appendDraftsContent+="</li>";
    appendDraftsContent+="</ul>";
    document.getElementById("mainDiv").innerHTML=appendDraftsContent;
}
function showSent()
{
    var appendSentContent="<br /><br /><form action=\"sent\" name=\"sent1\">  <input type=\"submit\" id=\"view1\" name=\"view1\" value=\"view\"/>            <ul id=\"messages\">";
    appendSentContent+="<li id=\"message1\" class=\"message\" onclick=\"showMessage(ssender1.innerHTML,subject1.innerHTML,\"sent\")\">";
    appendSentContent+="<span id=\"sender1\" class=\"sender\">Niveditha</span>";
    appendSentContent+="<span id=\"subject1\" class=\"subject\">Re:Hari</span>";
    appendSentContent+="<span id=\"date1\" class=\"date\">Jan 12</span>";
    appendSentContent+="</li>";
    appendSentContent+="<li id=\"message2\" class=\"message\" onclick=\"showMessage(ssender1.innerHTML,subject1.innerHTML,\"sent\")\">";
    appendSentContent+="<span id=\"sender2\" class=\"sender\">Hari</span>";
    appendSentContent+="<span id=\"subject2\" class=\"subject\">Re:hackathon</span>";
    appendSentContent+="<span id=\"date2\" class=\"date\">Jan 12</span>";
    appendSentContent+="</li>";
    appendSentContent+="<li id=\"message3\" class=\"message\" onclick=\"showMessage(ssender1.innerHTML,subject1.innerHTML,\"sent\")\">";
    appendSentContent+="<span id=\"sender3\" class=\"sender\">Steve</span>";
    appendSentContent+="<span id=\"subject3\" class=\"subject\">codechef</span>";
    appendSentContent+="<span id=\"date3\" class=\"date\">Jan 11</span>";
    appendSentContent+="</li>";
    appendSentContent+="</ul></form>";
    document.getElementById("mainDiv").innerHTML=appendSentContent;
}
function showMessage(sender,message,mode)
{
    var messageContent="";
    if(mode=="inbox")
	messageContent="Sender: ";
    else 
	messageContent="Recipient: ";
    messageContent+="<div id=\"otherUser\">"+sender+"</div>";
    messageContent+="<br /><br /><div id=\"otherMessage\">"+message+"</div>";
    document.getElementbyId("mainContent").innerHTML=messageContent;
	
    
}
