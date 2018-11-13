 function factorial (n)
 {
     if(n===0 || n===1)
     {
        n=1;
     }
     else
    {
        for (i=n;i!=2;i--)
        {
        n=(n*(i-1));
        console.log(n);
        }
    }
    let FinalResult=n;
    return FinalResult;
}

function apifinal(AdviceNumber){
    for(i=AdviceNumber;i>0;i--)
    {
fetch('https://api.chucknorris.io/jokes/random')
.then(response =>response.json())
.then(result=>{
    console.log(result);
    console.log(result.value);
    let advicetest=result.value;
    var AdviceElement = document.createElement("li");
    var AdviceText = document.createTextNode((advicetest));       
   AdviceElement.appendChild(AdviceText);                                
   document.getElementById("ApiList").appendChild(AdviceElement);
    });
    }

    









}