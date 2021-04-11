if (sessionStorage.getItem('userId') === null) {
	console.log(`This is a new User!`)
	createUser()
}

function createUser() {
	
	if (/channels/.test(window.location.href)) {
			window.location.replace("/welcome");
	}
	
	var username = prompt(`What's your name?`)
	
	if (username == '' || username == null) {
		alert(`please enter a name!`)
		createUser()
	} else {		
		var user = {
			"username": username
		}
		
		fetch(`/users/createUser`,{
		method: "POST",
		headers: {
			"Content-Type": "application/json"
		},
		body: JSON.stringify(user)
	})
		.then((response) => response.json())
		.then((data) => {
			sessionStorage.setItem('userId', data.id)
		})
	}
}

if (document.querySelector("#chatbox")) {
	var chatbox = document.querySelector("#chatbox")

	chatbox.addEventListener('keypress', (press) => {
		if (press.key === 'Enter' && chatbox.value != '') {
			press.preventDefault()
			var channelId = document.querySelector("#channelId")
			var username = document.querySelector("#username")
			var chatMessage = {
				"channelId": channelId.value,
				"username": username.value,
				"message": chatbox.value
		}
		
		fetch(`/channels/postMessage`,{
			method: "POST",
			headers: {
				"Content-Type": "application/json"
			},
			body: JSON.stringify(chatMessage)
		})
		chatbox.value = ''
		}
	})

	var chatContent = setInterval(getMessages, 500)

	function getMessages() {
		var channelId = document.querySelector("#channelId")	
		var channel = {
				"id": channelId.value
			}
		fetch(`/channels/allMessages`,{
			method: "POST",
			headers: {
				"Content-Type": "application/json"
			},
			body: JSON.stringify(channel)
		})
			.then((response) => response.json())
			.then((data) => {
				console.log(data)
				var chat = document.querySelector("#chat")
				chat.innerHTML = ''
				if (data.messages == '') {
					chat.innerHTML = 'not much going on here yet.. chat away dude!'
				}
				data.messages.forEach(aMessage => {
	  			chat.innerHTML += '<b>' + aMessage.username + ': ' + '</b>' + aMessage.message + '<br />'
				})			
			})
	}
}