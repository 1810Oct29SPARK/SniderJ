


let panelFootHolder= document.getElementsByClassName("panelFoot");
window.onload = function()
{
    console.log("hello world");
    arraylist(panelFootHolder);
}


function arraylist(item){
    for(i=0;i<item.length;i++)
    {
        if(item[i].children[0]==undefined)
        {
            let divFooter = document.createElement("div");
            divFooter.style.padding="10px";
            item[i].appendChild(divFooter);
        }
    }
}

function adviceGenerate(AdviceNumber){
    let adviceList=document.getElementById("adviceList");
    while (adviceList.firstChild) {
        adviceList.removeChild(adviceList.firstChild);
    }
    for(i=AdviceNumber;i>0;i--)
    {
fetch('https://api.adviceslip.com/advice')
.then(response =>response.json())
.then(result=>{
    let adviceList=document.getElementById("adviceList");
   let advicetest=result.slip.advice;
    var AdviceElement = document.createElement("li");
   var AdviceText = document.createTextNode((advicetest));       
   AdviceElement.appendChild(AdviceText);                                
   adviceList.appendChild(AdviceElement);
   var br = document.createElement("br");
   adviceList.appendChild(br);

    });
    }
}



function ghostQuiz() {
    var radios = document.getElementsByName("Ghost");
    var answerPicked = false;
    var userAnswer;
    var QuestionResult= document.getElementById("questionCorrectGhost");

    for(i=0 ; i < radios.length; i++ ) {
       if(radios[i].checked) {
         answerPicked = true;
         userAnswer = radios[i].value;
       }
    } 
    if(!answerPicked) {
      QuestionResult.innerHTML="You didn't pick a choice!";
      return;
    }
    if(userAnswer === "Interact") {
        QuestionResult.style.color="Green";
        QuestionResult.innerHTML="Correct!";
    }
    else {
        QuestionResult.style.color="Red";
        QuestionResult.innerHTML="Incorrect!";
    }
}

function graveQuiz() {
    var radios = document.getElementsByName("Lincoln");
    var answerPicked = false;
    var userAnswer;
    var QuestionResult= document.getElementById("questionCorrectGrave");

    for(i=0 ; i < radios.length; i++ ) {
       if(radios[i].checked) {
         answerPicked = true;
         userAnswer = radios[i].value;
       }
    } 
    if(!answerPicked) {
      QuestionResult.innerHTML="You didn't pick a choice!";
      return;
    }
    if(userAnswer === "WhiteHouse") {
        QuestionResult.style.color="Green";
        QuestionResult.innerHTML="Correct!";
    }
    else {
        QuestionResult.style.color="Red";
        QuestionResult.innerHTML="Incorrect!";
    }
}

function demonQuiz() {
    var radios = document.getElementsByName("demon");
    var answerPicked = false;
    var userAnswer;
    var QuestionResult= document.getElementById("questionCorrectDemon");

    for(i=0 ; i < radios.length; i++ ) {
       if(radios[i].checked) {
         answerPicked = true;
         userAnswer = radios[i].value;
       }
    } 
    if(!answerPicked) {
      QuestionResult.innerHTML="You didn't pick a choice!";
      return;
    }
    if(userAnswer === "Oni") {
        QuestionResult.style.color="Green";
        QuestionResult.innerHTML="Correct!";
    }
    else {
        QuestionResult.style.color="Red";
        QuestionResult.innerHTML="Incorrect!";
    }
}

function maryQuiz() {
    var radios = document.getElementsByName("mary");
    var answerPicked = false;
    var userAnswer;
    var QuestionResult= document.getElementById("questionCorrectMary");

    for(i=0 ; i < radios.length; i++ ) {
       if(radios[i].checked) {
         answerPicked = true;
         userAnswer = radios[i].value;
       }
    } 
    if(!answerPicked) {
      QuestionResult.innerHTML="You didn't pick a choice!";
      return;
    }
    if(userAnswer === "Execution") {
        QuestionResult.style.color="Green";
        QuestionResult.innerHTML="Correct!";
    }
    else {
        QuestionResult.style.color="Red";
        QuestionResult.innerHTML="Incorrect!";
    }
}