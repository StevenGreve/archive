/* Will pause and play a mp3 file.
----------------------------------*/
// This one will only for one class/ID. 
const audioElement = document.getElementById("audio");
document.getElementById("play").addEventListener("click", function(){
    if (audioElement.paused){
        audioElement.play();
    }
    else{
        audioElement.pause();
    }
});

// This one will work for multiple classes/ID's. 
const audioElement = document.querySelectorAll("#audio");
const playElement = document.querySelectorAll("#play");

audioElement.forEach(audioElement => {
    for(let i = 0; i < playElement.length; i++){
        playElement[i].addEventListener("click", function(){
            if (audioElement.paused){
                audioElement.play();
            }
            else{
                audioElement.pause();
            }
        })
    }
});
