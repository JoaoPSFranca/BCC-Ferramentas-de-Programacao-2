console.clear();

let numeros = [1, 20, -5, 0, 8, -20, -6];

// 1) Utilize a função forEach para exibir os números positivos.
console.log("Positivos: ");
numeros.forEach((item) => { if (item > 0) console.log(item); });

// 2) Utilize a função forEach para exibir os números negativos.
console.log("Negativos: ");
numeros.forEach((item) => { if (item < 0) console.log(item); });

// 3) Utilize a função reduce para somar todos os números do vetor e apresentar o resultado.
let soma = numeros.reduce((result, item) => result + item);
console.log("Soma dos itens: " + soma);

// 4) Utilize a função reduce para somar todos os números ímpares do vetor e apresentar o resultado.
let soma_impar = numeros.reduce((result, item) => {
    // if (item % 2 != 0)
    //     return result + item;
    // else
    //     return result;

    return (item % 2 != 0) ? result + item : result; 
});
console.log("Soma dos impares: " + soma_impar);

// 5) Utilize a função forEach para mostrar todos os números múltiplos de 5.
console.log("Multiplos de 5: ");
numeros.forEach(item => { if (item % 5 == 0) console.log(item); });

// 6) Apresente uma mensagem informando se existe algum elemento negativo.
if (numeros.findIndex(item => item < 0) != -1) 
    console.log("Há elemento negativo. ");
else
    console.log("Não há elemento negativo. ");

// 7) Apresente uma mensagem informando se todos os elementos são pares.
if (numeros.findIndex(item => item % 2 != 0) != -1) 
    console.log("Nem todos os elementos são pares");
else 
    console.log("Todos os elementos são pares");
