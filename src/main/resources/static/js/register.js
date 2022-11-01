let name;
let email;
let password;
let id;

function register() {
    name =  document.getElementById("name").value;
    email = document.getElementById("email").value;
    password = document.getElementById("password").value;
    if (name!=null&&email!=null&&password!=null) {
        const input = {
            "name": name.toString(),
            "email": email.toString(),
            "password": password.toString()
        }
        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "http://localhost:8080/user/register",
            data: JSON.stringify(input),
            dataType: 'json',
            cache: false,
            timeout: 600000,
            success: function (data) {
                console.log(data);
                // sessionStorage.myID = user.id;
                // sessionStorage.myName = user.name;
                // sessionStorage.myEmail = user.name;
                // location.href = "http://localhost:8080/chat.html";

            },
            error: function (e) {
                console.log("ERROR : ", e);

            }
        });
    }

    //     fetch('http://localhost:8080/user/register', {
    //         method: 'POST', // or 'PUT'
    //         headers: {
    //             'Content-Type': 'application/json',
    //         },
    //         body: JSON.stringify(input),
    //     }).then((response) => response.json())
    //     .then((user) => {
    //         console.log(user);
    //         // sessionStorage.myID = user.id;
    //         // sessionStorage.myName = user.name;
    //         // sessionStorage.myEmail = user.name;
    //         // location.href = "http://localhost:8080/chat.html";
    //     })
    //     .catch((error) => {
    //         console.log('Error:', error);
    //     });
    // }

}
