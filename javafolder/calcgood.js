
window.onload = function(){
    console.log("hello world");
    document.getElementById("calculate").addEventListener("click",function(){
        let num1FromForm = parseFloat(document.getElementById("num1").value);
        let num2FromForm = parseFloat(document.getElementById("num2").value);
        let displayresultForm = document.getElementById("paragraph");

        let chosenOperation;
        let operationRadios = document.getElementsByName("operation");
        for (let i=0; i < operationRadios.length; i++) {
            if (operationRadios[i].checked) {
                chosenOperation = operationRadios[i].value;
            }
        }
        console.log(num1FromForm);
        console.log(num2FromForm);
        console.log(chosenOperation);
        console.log(displayresultForm);
        console.log(calculate(num1FromForm,num2FromForm,chosenOperation,displayresultForm));
        calculate(num1FromForm,num2FromForm,chosenOperation,displayresultForm);

    });
}



function calculate(num1, num2, operation,displayelement){
    let result=NaN;
    if (operation === "add"){
        result = parseFloat(num1)+parseFloat(num2);
    }
    if (operation === "subtract"){
        result = num1-num2;
    }
    if (operation === "divide"){
        result = num1/num2;
    }
    if (operation === "multiply"){
        result = num1*num2;
    }
    displayelement.innerHTML = result;
    return result;
    
}