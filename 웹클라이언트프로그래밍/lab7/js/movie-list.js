async function init() {
    const response = await fetch('http://localhost:8090/https://search.naver.com/search.naver?where=nexearch&sm=top_sug.pre&fbm=1&acr=2&acq=%EC%83%81%EC%98%81&qdt=0&ie=utf8&query=%EC%83%81%EC%98%81%EC%98%81%ED%99%94', {
    headers: {
      "X-Requested-With": "XMLHttpRequest"
    }
  });
  const body = response.text().then(function(html){
    var html_dom = new DOMParser().parseFromString(html,'text/html');
    console.log(html_dom.body);
    var movies = html_dom.querySelectorAll(".data_area");
    console.log(movies);
    display(movies);
  });
  }
  function display(movies) {
    const result = document.querySelector('#result');
    let string = '';
    movies.forEach((movie) => {
      var title = movie.querySelector(".area_text_box a").innerText;
      var genre = movie.querySelector(".info_group dd").innerText;
      var runtime = movie.querySelector(".info > dl:nth-child(1) > dd:nth-child(3)").innerText;
      var release = movie.querySelector(".info > dl:nth-child(2) > dd").innerText;
      var grade = movie.querySelector(".num").innerText;
      var guest = movie.querySelector(".info > dl:nth-child(3) > dd");
      if (guest == null) guest = "";
      else guest = guest.innerText;
      var poster = movie.querySelector("img").src;
      string += `<table><tr><th>영화</th><td>${title}</td></tr>
                  <tr><th>장르</th><td>${genre}</td></tr>
                  <tr><th>상영시간</th><td>${runtime}</td></tr>
                  <tr><th>개봉일</th><td>${release}</td></tr>
                  <tr><th>평점</th><td>${grade}</td></tr>
                  <tr><th>출연</th><td>${guest}</td></tr>
                  <tr><th>포스터</th><td><img width="178" height="260" src="${poster}"></td></tr></table>`;
    });            
    result.innerHTML = string;
  }
  init();