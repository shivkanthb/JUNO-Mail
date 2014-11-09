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
   
	
	 
	 if(allLetter(uname))  
    { 
	 if(ValidateEmail(uemail))  
    {
	if(userid_validation(uid,5,12))  
    { 
    if(pwd_validation(pwd,7,12))  
    { 
	if(pwdd_validation(pwdd,7,12))  
    {
	if(validsex(umsex,ufsex))  
    { 
    if(countryselect(ucountry))  
    {   
    }  
    }   
    }  
    }   
    }  
    }  
	}
      
    
	
    return false;  
      
    } 
	function userid_validation(uid,mx,my)  
    {  
    var uid_len = uid.value.length;  
    if (uid_len == 0 || uid_len >= my || uid_len < mx)  
    {  
    alert("User Id should length should be between "+mx+" to "+my);  
    uid.focus();  
    return false;  
    }  
    return true;  
    }  
    function pwd_validation(pwd,mx,my)  
    {  
    var pwd_len = pwd.value.length;  
    if (pwd_len == 0 ||pwd_len >= my || pwd_len < mx)  
    {  
    alert("Password length should  be between "+mx+" to "+my);  
    pwd.focus();  
    return false;  
    }  
    return true;  
    }  
	function pwdd_validation(pwdd,mx,my)  
    {  
    var pwd_len1 = pwdd.value.length;  
    if (pwd_len1 == 0 ||pwd_len1 >= my || pwd_len1 < mx)  
    {  
    alert("Password length should  be between "+mx+" to "+my);  
    pwdd.focus();  
    return false;  
    }  
    return true;  
    }  
	
    function allLetter(uname)  
    {   
    var letters = /^[A-Za-z]+$/;  
    if(uname.value.match(letters))  
    {  
    return true;  
    }  
    else  
    {  
    alert('Only Alphabets please');  
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
    return true;  
    }  
    else  
    {  
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
    alert('Select Male/Female');  
    umsex.focus();  
    return false;  
    }  
    else  
    {  
    return true;  
    }  
    }  