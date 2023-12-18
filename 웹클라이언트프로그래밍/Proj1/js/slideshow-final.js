var slides = document.querySelectorAll("#slides > img");
var slider = document.querySelector("#slides");
var k = document.querySelectorAll("#bar");
var prev = document.getElementById("prev");
var next = document.getElementById("next");
var current = 0;

showSlides(current);
prev.onclick = prevSlide;
next.onclick = nextSlide;

function showSlides(n) {
  slider.style.transform = `translateX(${n * -1200}px)`;
}

slider.onmouseover = function() {
  for (let i=0; i<k.length; i++) {
    k[i].style.color = "white";
  }
} 

function prevSlide() {
  if (current > 0) current -= 1;
  else
    current = slides.length - 1;
    showSlides(current);
}

function nextSlide() {
  if (current < slides.length - 1) current += 1;
  else
    current = 0;
    showSlides(current);  
}

function handleIndex(target) {
  current = Number(target.value)-1;
  showSlides(current);
}

function newRegister() {
  var newItem = document.createElement("li");  // 요소 노드 추가
  var subject = document.querySelector("#subject");  // 폼의 텍스트 필드
  var newText = document.createTextNode(subject.value);  // 텍스트 필드의 값을 텍스트 노드로 만들기
  var trash = document.createElement("img");
  trash.src = "images/trash.png";
  trash.style.width = "30px";
  trash.style.height = "25px";
  newItem.style.display = "flex";
  newItem.style.justifyContent = "space-between";
  trash.onclick = function() {
    newItem.remove();
  };
  newItem.appendChild(newText);   // 텍스트 노드를 요소 노드의 자식 노드로 추가
  newItem.appendChild(trash);

  var itemList = document.querySelector("#itemList");  // 웹 문서에서 부모 노드 가져오기
  itemList.insertBefore(newItem, itemList.childNodes[0]);  // 자식 노드중 첫번째 노드 앞에 추가 
  itemList.appendChild(newItem);  // 새로 만든 요소 노드를 부모 노드에 추가

  subject.value="";
}
var ad = document.querySelector('.ad');
var box = document.querySelector('.box');
  ad.onmouseover = function() {
      box.style.display="none";
      void box.offsetWidth;
      box.style.display="flex";
    };