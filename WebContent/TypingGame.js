var display = document.getElementById("display");
 
  //display.style.display='display';
  //display.style.visibility='visible';
let text =
    "Le Binh Khang va Quoc Khanh blala. Lorem ipsum dolor sit amet consectetur adipisicing elit. Maxime excepturi officiis molestiae voluptates eos labore adipisci ipsum sit, distinctio, laborum illo quibusdam beatae magni ipsam cum est, dolorem voluptate? Repellendus"

let index = 0; // index letter current user typed.

/*
class Text using:
1. Enter variable text

*/

class Text {
    constructor(text) {
        this.spans = []; // stores spans
        this.text = text; // stores text 


        // create spans using this.text
        this.createSpans = function () {
            // get each letter and call function createSpan
            // after that add to span
            for (let i = 0; i < this.text.length; i++) {
                this.spans.push(this.createSpan(text[i]));
            }

            return this.spans;
        };

        // create span and add letter to span
        this.createSpan = function (letter) {
            let span = document.createElement("span");
            span.innerHTML = letter;
            span.classList.add("letter");
            return span;
        };
    }
}



function addSpansToDisplay() {
    // create spans
    let spans = new Text(text).createSpans();

    // add span to paragraph
    for (let i = 0; i < spans.length; i++) {
        display.appendChild(spans[i]);
    }

    return spans;
}

let spans = addSpansToDisplay();
spanAddCurrent();


// list event key down when user pressed key
addEventListener("keydown", (e) => {
    // when user press Shift will do nothing
    if (e.keyCode == 16) {
        return;
    }


    let span = spans[index];
    let letter = span.innerHTML;

    if (letter == e.key) {
        spanRemoveCurrent();
        index++;
        typeCorrect();
    } else {
        typeIncorrect();
    }

    /*
        - When type correct will:
            1. add class correct (to change color letter)
            2. add background animate (pointer on letter)
    */
    function typeCorrect() {
        span.classList.remove("letter");
        span.classList.add("correct");
        spanAddCurrent();
    }

    /*
        - When type in-correct will:
        1. add class in-correct ( change style of letter particular is change color to red)
    */
    function typeIncorrect() {
        span.classList.remove("letter");
        span.classList.add("incorrect");

    }
})


// add class current of span current
function spanAddCurrent() {
    spans[index].classList.add("current");
}

// remove class current of span current
function spanRemoveCurrent() {
    spans[index].classList.remove("current");
}
