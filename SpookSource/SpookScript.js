


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