window.onload = function () {
    // forward when click title
    document.querySelector('.title').addEventListener('click', () => window.location.href = 'index.html');

    // toggle display
    document.querySelectorAll('.outline-2').forEach((outline) => {
        const toggledisplay = (w) => {
            w.style.display = (w.style.display == 'none') ? 'block' : 'none';
        };
        
        outline.querySelector('h2').addEventListener('click', () => {
            outline.querySelectorAll('div').forEach(toggledisplay);
        });
    });
    

    if(/Android/i.test(navigator.userAgent)) {
    }

};
