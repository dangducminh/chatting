function register() {
    let name =  document.getElementById("name").value;
    let email = document.getElementById("email").value;
    let password = document.getElementById("password").value;
    if (name!=null&&email!=null&&password!=null) {
        const input = {
            "name": name.toString(),
            "email": email.toString(),
            "password": password.toString()
        }

        fetch('http://localhost:8080/user/register', {
            method: 'POST', // or 'PUT'
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(input)
        })
            .then(response =>response.json())
            .then(data=>{
                sessionStorage.setItem("myID",data.uid);
                location.href = "http://localhost:8080/chat.html?";
            })
            .catch((error) => {
                console.log('Error:', error);
            });
    }
}
