


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