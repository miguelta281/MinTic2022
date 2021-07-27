const testApi = async  () => {
    const resultText =  await fetch('http://www.omdbapi.com/?t=harry&type=movie&apikey=7b87412f',{
    method : 'GET'
});

    
    if(resultText.ok){
        var resultJson = await resultText.json(); //Obtener los datos 
        console.log(resultJson.Title);
        console.log(resultJson.Plot);
        console.log(resultJson.Actors);
    }

   

    const resultPoster = await fetch(`http://img.omdbapi.com/?i=${resultJson.imdbID}&type=movie&apikey=7b87412f`,{
        method: 'GET'
    });

    if(resultPoster.ok){
        posterJson = await resultPoster.url;
        console.log(posterJson);
    }


}
    

testApi();