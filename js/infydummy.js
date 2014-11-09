    function formValidation()  
    {  
     
    var uname = document.registration.name;
	var uemail = document.registration.email;
	var uid = document.registration.username;
	var pwd = document.registration.password;
    var pwdd = document.registration.rpass;
	var umsex = document.registration.msex;  
    var ufsex = document.registration.fsex;	  
    var ucountry  = document.registration.country;
   
	 var e=document.getElementById('password').value;
	 var e1=document.getElementById('rpass').value;
	 
	 if(allLetter(uname))  
    { 
	 if(ValidateEmail(uemail))  
    {
	if(userid_validation(uid,5,12))  
    { 
    if(pwd_validation(pwd,8,12))  
    { 
	if(pwdd_validation(pwdd,8,12))  
    {
	if(ValidCaptcha())
	{
	if(validsex(umsex,ufsex))  
    { 
    if(countryselect(ucountry))  
    {
     if(terms())
	 {
	 window.alert("you hav entered the details successfully");
	 return true;
	 }
	
    } 	
    }   
    }  
    }   
    }  
    }  
	}
    } 
    
	
    return false;  
      
    } 
	function terms()
	{
	if (document.getElementById('agreed').checked == false) {

	alert("Please agree to the terms and conditions");
	agreed.focus();
	return false;
	}
	return true;
	}
	
	
	
	
	
	function userid_validation(uid,mx,my)  
    {  
    var uid_len = uid.value.length;
    if(uid_len==0)
	{
	document.getElementById("username1").innerHTML="Enter your username!";
	}
	
    else if ( uid_len >= 12 || uid_len < 5)  
    {  
    alert("User Id length should be between "+mx+" to "+my);  
    uid.focus();  
    return false; 
    }
    else	
	{
	document.getElementById("username1").innerHTML=" ";
    return true;
    }	
    }  
    function pwd_validation(pwd,mx,my)  
    {  
    var pwd_len = pwd.value.length;  
	if(pwd_len==0)
	{
	document.getElementById("password1").innerHTML="Enter your password!";
	}
    else if (pwd_len >= 12 || pwd_len < 8)  
    {  
    alert("Enter a valid passeword....Password length should  be between "+mx+" to "+my);  
    pwd.focus();  
    return false;  
    }  
	else
	{
	document.getElementById("password1").innerHTML=" ";
    return true; 
    }	
    }  
	function pwdd_validation(pwdd,mx,my)  
    {
	
	 var e=document.getElementById("password").value;
	 var e1=document.getElementById("rpass").value;
    //var pwd_len1 = pwdd.value.length;  
    /*if (pwd_len1 == 0 ||pwd_len1 >= my || pwd_len1 < mx)  
    {  
    alert("Password length should  be between "+mx+" to "+my);  
    pwdd.focus();  
    return false;  
    } */
	if(e1=="")
	document.getElementById("rpass1").innerHTML="Enter the confirmation password";
     else if(e!=e1) {
    alert("Your passwords do not match. Please type more carefully.");
    return false;
  }
  else
  {
  document.getElementById("rpass1").innerHTML=" ";
  return true;
   }	
    
    }  
	
	
	
	
	
	function pwdStrength(password) 

{ 

 var pass = new Array(); 

 pass[0] = "Very Weak"; 

 pass[1] = "Weak"; 

 pass[2] = "Better"; 

 pass[3] = "Medium"; 

 pass[4] = "Strong"; 

 pass[5] = "Strongest"; 

 var temp1 = 0; 

 if (password.length > 5) temp1++; 

 if ( ( password.match(/[a-z]/) ) && ( password.match(/[A-Z]/) ) ) temp1++; 

 if (password.match(/\d+/)) temp1++; 

 if ( password.match(/.[!,@,#,$,%,^,&,*,?,_,~,-,(,)]/) ) temp1++; 

 if (password.length > 10) temp1++; 

 document.getElementById("pwdDescription").innerHTML = pass[temp1]; 

 //document.getElementById("pwdStrength").className = "strength" + temp1; 

} 
	
	
	
	
	
	
 
 
 
 
 function DrawCaptcha()
    {
        var a = Math.ceil(Math.random() * 10)+ '';
        var b = Math.ceil(Math.random() * 10)+ '';       
        var c = Math.ceil(Math.random() * 10)+ '';  
        var d = Math.ceil(Math.random() * 10)+ '';  
        var e = Math.ceil(Math.random() * 10)+ '';  
        var f = Math.ceil(Math.random() * 10)+ '';  
        var g = Math.ceil(Math.random() * 10)+ '';  
        var code = a + ' ' + b + ' ' + ' ' + c + ' ' + d + ' ' + e + ' '+ f + ' ' + g;
        document.getElementById("txtCaptcha").value = code
    }

    // Validate the Entered input aganist the generated security code function   
    function ValidCaptcha(){
	
	
        var str1 = removeSpaces(document.getElementById('txtCaptcha').value);
        var str2 = removeSpaces(document.getElementById('txtInput').value);
		if(str2=="")
		document.getElementById("txtInput1").innerHTML="Enter the above code";
		
        if (str1 == str2)
		
		{
		document.getElementById("txtInput1").innerHTML=" ";
		return true;
		}        
        return false;
        
    }

    // Remove the spaces from the entered and generated code
    function removeSpaces(string)
    {
        return string.split(' ').join('');
    }
    
	
	
	
	
	
	
	
	
	
	
	

    function allLetter(uname)  
    {   
    var letters = /^[A-Za-z]+$/;  
    if(uname.value.match(letters))  
    {
     document.getElementById("name1").innerHTML=" ";	
	
    return true;  
    }  
    else  
    {  
	
	var n=document.getElementById("name").value;
	if(n=="")
	
	document.getElementById("name1").innerHTML="Enter your name!";
	
	
	else
	{
	
    alert('please enter a valid user name: (Only Alphabets please)');  
	}
    uname.focus();  
    return false;  
    }  
    }  
    
    
	function countryselect(ucountry)  
    {  
    if(ucountry.value == "Default")  
    {  
    alert('Select your country from the list');  
    ucountry.focus();  
    return false;  
    }  
    else  
    {  
    return true;  
    }  
    }	
    
    function ValidateEmail(uemail)  
    {  
    var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;  
    if(uemail.value.match(mailformat))  
    {  
	document.getElementById("email1").innerHTML=" ";
    return true;  
    }  
    else  
    {  
	if(uemail.value=="") 
	document.getElementById("email1").innerHTML="Enter your email!";
	else
    alert("You have entered an invalid email address!");  
    uemail.focus();  
    return false;  
    }  
    } 
	function validsex(umsex,ufsex)  
    {  
    x=0;  
      
    if(umsex.checked)   
    {  
    x++;  
    } if(ufsex.checked)  
    {  
    x++;   
    }  
    if(x==0)  
    {  
    window.alert("Select Male/Female");  
    umsex.focus();  
    return false;  
    }  
    else  
    {  
    return true;  
    }  
    }  