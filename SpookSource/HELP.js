let Tampaweather={};

//send get request to this endpoint for weather
let weatherApiUrl='hi'

function getWeather()
{
    fetch(weatherApiUrl).then((response)=> 
    {
        return Tampaweather=response.json();
    })
    .then((data) => 
    {
        Tampaweather =data;
        console.log("the temperature is "+data.main.temp+" degrees")
    })

}

//fetch with post requests
//get a token for api such as Artsy

let Token='hi';
let artsyURl='url';
function getArtsyToken()
{
    let clientId ='id';
    let clientSecret='secret';

    fetch()
}

function ArrayRotate(Numberlist, RotateNumber)
{

    for (i=0;i<RotateNumber;i++)
	{
        IndexHolder= Numberlist[0];
        for(x=0;x<Numberlist.length;x++)
        {
            if(x===(Numberlist.length-1))
            {
            Numberlist[x]=IndexHolder;
            } 
            else
            {
            Numberlist[x]=Numberlist[(x+1)];
            }
        }
    }    

return(Numberlist);

}

