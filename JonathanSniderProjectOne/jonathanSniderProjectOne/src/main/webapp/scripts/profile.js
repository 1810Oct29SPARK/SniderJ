/**
 * 
 */
window.onload = function(){
	populateUser();
}

function populateUser(){
	//send a GET request to localhost:7001/SessionMgmtDemo/session
	fetch("http://localhost:7001/jonathanSniderProjectOne/session").then(function(response) {
		return response.json();
	}).then(function(data){
		//check whether there was a valid session returned
		//define behavior for no user returned 
		if (data.session === null) {
			console.log("data.session was null");
			window.location = "http://localhost:7001/SessionMgmtDemo/login";
		} else {
			//define behavior for user returned
			user = data;
			document.getElementById("username").innerText = "Username: "+user.logInUsername;
			document.getElementById("firstname").innerText = "First name: "+user.firstName;
			document.getElementById("lastname").innerText = "Last name: "+user.lastName;
			//document.getElementById("email").innerText = "Email: "+user.email;
		}
	});
	

	
	
}