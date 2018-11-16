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

