//**************** user profile changes ***************

function changePassword() {

	var selectedUserEmail = $("#user-email").val();

	if (selectedUserEmail != null && selectedUserEmail != "") {
		var password = prompt("Please enter new password");

		if (password != null && password != "") {
			// to do get
			$.post("/airbnb/UserServlet", {
				action : "changePassword",
				password : password,
				email : selectedUserEmail
			}).done(function(status) {
				if (status == 1)
					alert("Password updated successfully");
				else if (status == 0)
					alert("Incorrect Password");
				else
					alert("Unknow error");
			});

		}else {
			alert("Enter new password");
		}

	} else {
		alert("User not selected");
	}

}

function deleteAccount(){

	var selectedUserEmail = $("#user-email").val();

	if (selectedUserEmail != null && selectedUserEmail != "") {

		if (confirm("Do you want to delete this user?")) {
			$.post("/airbnb/UserServlet", {
				action : "deleteUser",
				email : selectedUserEmail
			}).done(function(status) {
				if (status == 1) {
					if (alert("User deleteed successfully")) {
					} else
						window.location.load();
				} else if (status == 0)
					alert("Incorrect Data");
				else
					alert("Unknow error");
			});

		}

	} else {
		alert("User not selected");
	}

}