document.addEventListener("DOMContentLoaded", function () {

    /**
     * Form Select
     */
    class FormSelect {
        constructor($el) {
            this.$el = $el;
            this.options = [...$el.children];
            this.init();
        }

        init() {
            this.createElements();
            this.addEvents();
            this.$el.parentElement.removeChild(this.$el);
        }

        createElements() {
            // Input for value
            this.valueInput = document.createElement("input");
            this.valueInput.type = "text";
            this.valueInput.name = this.$el.name;

            // Dropdown container
            this.dropdown = document.createElement("div");
            this.dropdown.classList.add("dropdown");

            // List container
            this.ul = document.createElement("ul");

            // All list options
            this.options.forEach((el, i) => {
                const li = document.createElement("li");
                li.dataset.value = el.value;
                li.innerText = el.innerText;

                if (i === 0) {
                    // First clickable option
                    this.current = document.createElement("div");
                    this.current.innerText = el.innerText;
                    this.dropdown.appendChild(this.current);
                    this.valueInput.value = el.value;
                    li.classList.add("selected");
                }

                this.ul.appendChild(li);
            });

            this.dropdown.appendChild(this.ul);
            this.dropdown.appendChild(this.valueInput);
            this.$el.parentElement.appendChild(this.dropdown);
        }

        addEvents() {
            this.dropdown.addEventListener("click", e => {
                const target = e.target;
                this.dropdown.classList.toggle("selecting");

                // Save new value only when clicked on li
                if (target.tagName === "LI") {
                    this.valueInput.value = target.dataset.value;
                    this.current.innerText = target.innerText;
                }
            });
        }
    }

    document.querySelectorAll(".form-group--dropdown select").forEach(el => {
        new FormSelect(el);
    });

    /**
     * Hide elements when clicked on document
     */
    document.addEventListener("click", function (e) {
        const target = e.target;
        const tagName = target.tagName;

        if (target.classList.contains("dropdown")) return false;

        if (tagName === "LI" && target.parentElement.parentElement.classList.contains("dropdown")) {
            return false;
        }

        if (tagName === "DIV" && target.parentElement.classList.contains("dropdown")) {
            return false;
        }

        document.querySelectorAll(".form-group--dropdown .dropdown").forEach(el => {
            el.classList.remove("selecting");
        });
    });

    /**
     * Switching between form steps
     */
    class FormSteps {
        constructor(form) {
            this.$form = form;
            this.$next = form.querySelectorAll(".next-step");
            this.$prev = form.querySelectorAll(".prev-step");
            this.$step = form.querySelector(".form--steps-counter span");
            this.currentStep = 1;

            this.$stepInstructions = form.querySelectorAll(".form--steps-instructions p");
            const $stepForms = form.querySelectorAll("form > div");
            this.slides = [...this.$stepInstructions, ...$stepForms];

            this.init();
        }

        /**
         * Init all methods
         */
        init() {
            this.events();
            this.updateForm();
        }

        /**
         * All events that are happening in form
         */
        events() {
            // Next step
            this.$next.forEach(btn => {
                btn.addEventListener("click", e => {
                    e.preventDefault();
                    this.currentStep++;
                    this.updateForm();
                });
            });

            // Previous step
            this.$prev.forEach(btn => {
                btn.addEventListener("click", e => {
                    e.preventDefault();
                    this.currentStep--;
                    this.updateForm();
                });
            });

            // Form submit
            this.$form.querySelector("form").addEventListener("submit", e => this.submit(e));
        }

        /**
         * Update form front-end
         * Show next or previous section etc.
         */
        updateForm() {
            this.$step.innerText = this.currentStep;

            // TODO: Validation

            this.slides.forEach(slide => {
                slide.classList.remove("active");

                if (slide.dataset.step == this.currentStep) {
                    slide.classList.add("active");
                }
            });

            this.$stepInstructions[0].parentElement.parentElement.hidden = this.currentStep >= 5;
            this.$step.parentElement.hidden = this.currentStep >= 5;

            if (this.currentStep >= 5) {


                //sacks quantity  overview
                const sacksForm = document.getElementById("sacks");
                const sacksQuantity = document.getElementById("sacks-quantity");
                const sacksNumber = sacksForm.value;
                sacksQuantity.innerText = sacksNumber;

                const declension = document.getElementById("sacks-declension");
                if (sacksNumber === 1) {
                    declension.innerText = "worek";
                } else if ((sacksNumber > 1 && sacksNumber % 10 === 1) || sacksNumber % 10 > 4) {
                    declension.innerText = "worków";
                } else if (sacksNumber % 10 > 1 && sacksNumber % 10 < 5) {
                    declension.innerText = "worki";
                }

                //address overview
                const streetForm = document.getElementById("streetForm");
                const street = document.getElementById("street");
                street.innerText = streetForm.value;
                const cityForm = document.getElementById("cityForm");
                const city = document.getElementById("city");
                city.innerText = cityForm.value;
                const zipForm = document.getElementById("zipForm");
                const zip = document.getElementById("zip");
                zip.innerText = zipForm.value;
                const telephoneForm = document.getElementById("telephoneForm");
                const telephone = document.getElementById("telephone");
                telephone.innerText = telephoneForm.value;

                //pickup overview
                const dateForm = document.getElementById("dateForm");
                const date = document.getElementById("date");
                date.innerText = dateForm.value;
                const timeForm = document.getElementById("timeForm");
                const time = document.getElementById("time");
                time.innerText = timeForm.value;
                const commentForm = document.getElementById("commentForm");
                const comment = document.getElementById("comment");
                comment.innerText = commentForm.value;

                //institution overview

                // const institutionId = document.getElementById("institutionForm").value;
                // const charity = document.getElementById("charity");
                // const institutionDescriptionElements = document.getElementsByClassName("insts");
                //
                // for (let element of institutionDescriptionElements) {
                //   const instIdElement = element.getElementsByClassName("instId")
                //   const instNameElement = element.getElementsByClassName("title")
                //
                //     if (instIdElement[0].innerText === institutionId) {
                //       charity.innerText = instNameElement[0].innerText
                //     }
                // }

                const charity = document.getElementById("charity");
                const radioButton = document.querySelector("[name = 'institution']:checked");
                const institutionName = radioButton.parentElement.querySelector(".title");
                charity.innerText = institutionName.innerText;

                //categories overview
                const categoriesDonated = document.getElementById("donated-goods");
                const selectedCategories = document.querySelectorAll("[name = 'categories']:checked");
                const lastCategory = selectedCategories[selectedCategories.length -1];
                const lastCategoryElement = lastCategory.parentElement.querySelector(".description");
                console.log(lastCategoryElement.innerText)
                let text = "";
                for (const category of selectedCategories) {
                    const categoryElement = category.parentElement.querySelector(".description")
                    text += categoryElement.innerText;
                    if (category.innerText === lastCategoryElement.innerText){
                        text += " "
                    } else {
                        text += ", "
                    }
                }
                categoriesDonated.innerText = text;
            }

        }

    }

    const form = document.querySelector(".form--steps");
    if (form !== null) {
        new FormSteps(form);
    }
});