var command = document.querySelector("#send");
command.onclick = REST_command;
var result = document.querySelector("#result");

function REST_command() {
  var val = document.querySelector('.sel:checked');
  console.log(val);
  if(!val) return;
  val = val.value;
  var id = document.querySelector("#id").value;
  var title = document.querySelector("#title").value;
  var genre = document.querySelector("#genre").value;
  var rating = document.querySelector("#rating").value;
  var actor = document.querySelector("#actor").value;
  var poster = document.querySelector("#poster").value;
  result.value="";
  switch(val) {
    case "get_all":
      fetch("http://127.0.0.1:52273/movie")
        .then(response => response.json())
        .then(movies => {display(movies);console.log(movies);});
      break;
    case "get_id":
      fetch(`http://127.0.0.1:52273/movie/${id}`)
        .then(response => response.json())
        .then(movies => {display(movies);console.log(movies);});
      break;
    case "post":
      fetch("http://127.0.0.1:52273/movie", {
        method: "POST",
        headers:{
          'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'
        },    
        body: new URLSearchParams({
          title: `${title}`,
          genre: `${genre}`,
          rating: `${rating}`,
          actor: `${actor}`,
          poster: `${poster}`
        }),
      })
      .then(response => response.json())
      .then(movies => {display(movies);console.log(movies);});
      break;
    case "put":
      fetch(`http://127.0.0.1:52273/movie/${id}`, {
        method: "PUT",
        headers:{
          'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'
        },    
        body: new URLSearchParams({
          title: `${title}`,
          genre: `${genre}`,
          rating: `${rating}`,
          actor: `${actor}`,
          poster: `${poster}`
        }),
      })
      .then(response => response.json())
      .then(movies => {display(movies);console.log(movies);});
      break;
    case "delete":
      fetch(`http://127.0.0.1:52273/movie/${id}`, {
        method: "DELETE",
      })
      .then(response => response.json())
      .then(movies => {display(movies);console.log(movies);});
      break;
    }
}

function display(movies) {
  let string = '';
  if(!Array.isArray(movies)) movies = [movies];
  if(!Object.keys(movies[0]).includes('status'))
    movies.forEach((movie) => {
      string += `<table><tr><th style="width:52px">ID</th><td style="width:322px">${movie.id}</td><td rowspan="5" style="padding-top:3px"><img width="276" height="400" src="${movie.poster}"></td></tr>
                  <tr><th style="width:52px">제목</th><td style="width:322px">${movie.title}</td></tr>
                  <tr><th style="width:52px">장르</th><td style="width:322px">${movie.genre}</td></tr>
                  <tr><th style="width:52px">평점</th><td style="width:322px">${movie.rating}</td></tr>
                  <tr><th style="width:52px">출연</th><td style="width:322px">${movie.actor}</td></tr>
                </table>`;
    });
  else
    string += `<table><tr><th>status</th><td style="width:322px">${movies[0].status}</td></tr></table>`;
  result.innerHTML = string;
}
