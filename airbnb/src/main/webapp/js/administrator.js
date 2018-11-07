window.onload = function() {

};

function selectUser(id) {
   var userCel = getElementById(id);

   getElementById("user-email").value = userCel.childNodes[0].value;
}

function messageUser()
{
   var message = prompt("Please enter your message");
}


function changePassword()
{
   var password = prompt("Please enter new password");
}

function deleteUser()
{
   confirm("Do you want to delete this user?");
}

function deletePlace()
{
   confirm("Do you want to delete this place?");
}
