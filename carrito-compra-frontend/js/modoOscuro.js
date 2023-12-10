let btnSwicht = document.querySelector('#btnDark');

btnSwicht.addEventListener('click', () => {
    document.body.classList.toggle('dark');
    btnSwicht.classList.toggle('active');
});