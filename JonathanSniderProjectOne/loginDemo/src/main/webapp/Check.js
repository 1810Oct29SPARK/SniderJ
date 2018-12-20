/**
 * 
 */

window.Onload= function(){
	populateUser();
	}


function populateUser(){
	//send a get request to localhost 7001/(projectname)/(servletURL)
	fetch('localhost:7001/loginDemo/session').then(
			function(response){
				return response.json()
			}).then(function (data){
				//parse response as json
				objReturned=JSON.parse(data);
				//define behavior when a user is returned and when no user is returned
			if(objReturned.session===null)
				{
				window.location= "http://localhost:7001/loginDemo/login";
				}
			else
				{
				user=data;
				document.getElementById("username").innerText= "Username: "+user.username;
				document.getElementById("firstname").innerText= "First Name: "+user.firstname;
				document.getElementById("lastname").innerText= "Last Name: "+user.lastname;
				document.getElementById("email").innerText= "E-mail: "+user.email;
				}
			});

}
