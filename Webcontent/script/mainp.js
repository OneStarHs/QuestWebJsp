
        var slider = document.querySelector('.slider');
        var images = document.querySelectorAll('.slider img');
        var buttons = document.querySelectorAll('.slider-navigation button');
        var currentSlide = 0;
        var slideInterval = setInterval(nextSlide, 2000); 
    
        function goToSlide(index) {
          images[currentSlide].style.display = 'none';
          buttons[currentSlide].classList.remove('active');
    
          currentSlide = index;
    
          images[currentSlide].style.display = 'block';
          buttons[currentSlide].classList.add('active');
        }
  
        function nextSlide() {
          var nextSlideIndex = (currentSlide + 1) % images.length;
          goToSlide(nextSlideIndex);
        }
