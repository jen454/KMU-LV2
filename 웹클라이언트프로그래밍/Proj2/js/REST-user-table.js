var command = document.querySelector("#send");
command.onclick = REST_command;
var result = document.querySelector("#result");

function REST_command() {
  var val = document.querySelector('.sel:checked');
  console.log(val);
  if(!val) return;
  val = val.value;
  var id = document.querySelector("#id").value;
  var name = document.querySelector("#name").value;
  var region = document.querySelector("#region").value;
  result.value="";
  switch(val) {
    case "get_all":
      fetch("http://127.0.0.1:52273/user")
        .then(response => response.json())
        .then(users => {display(users);console.log(users);});
      break;
    case "get_id":
      fetch(`http://127.0.0.1:52273/user/${id}`)
        .then(response => response.json())
        .then(users => {display(users);console.log(users);});
      break;
    case "post":
      fetch("http://127.0.0.1:52273/user", {
        method: "POST",
        headers:{
          'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'
        },    
        body: new URLSearchParams({
          name: `${name}`,
          region: `${region}`
        }),
      })
      .then(response => response.json())
      .then(users => {display(users);console.log(users);});
      break;
    case "put":
      fetch(`http://127.0.0.1:52273/user/${id}`, {
        method: "PUT",
        headers:{
          'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'
        },    
        body: new URLSearchParams({
          name: `${name}`,
          region: `${region}`
        }),
      })
      .then(response => response.json())
      .then(users => {display(users);console.log(users);});
      break;
    case "delete":
      fetch(`http://127.0.0.1:52273/user/${id}`, {
        method: "DELETE",
      })
      .then(response => response.json())
      .then(users => {display(users);console.log(users);});
      break;
    }
}

function display(users) {
  let string = '';
  if(!Array.isArray(users)) users = [users];
  if(!Object.keys(users[0]).includes('status'))
    users.forEach((user) => {
      string += `<table><tr><th>ID</th><td>${user.id}</td></tr>
                  <tr><th>이름</th><td>${user.name}</td></tr>
                  <tr><th>지역</th><td>${user.region}</td></tr>
                </table>`;
    });
  else
    string += `<table><tr><th>status</th><td>${users[0].status}</td></tr></table>`;
  result.innerHTML = string;
}
