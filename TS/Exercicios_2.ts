// Lista de exercícios 01

// const numeros: number[] = [1, 2, 3, 4, 5];

//     Crie uma função que retorne a quantidade de números pares do vetor numeros.
//     Crie uma função anônima que retorne a soma dos elementos ímpares do vetor numeros.
//     Crie uma arrow function que mostre no console os elementos em ordem inversa (do último para o primeiro).
//     Crie uma função para encontrar e retornar o maior elemento do array numeros.
//     Crie uma função para encontrar e retornar o menor elemento do array numeros.
//     Crie uma função para calcular e retornar a média entre os elemento do array numeros.
//     Criar uma função que retorne todos os elementos pares do array numeros.
console.clear();

const numeros: number[] = [1, 2, 3, 4, 5];

// 1)
function pares(): number {
    let count : number = 0;
    
    for (let item of numeros) 
        if(item % 2 == 0)
            count++;

    return count;
}

console.log("1 - Quantidade de pares: " + pares());

//2) 
const impares = function () : number {
    let count : number = 0;
    
    for (let item of numeros) 
        if(item % 2 != 0)
            count++;

    return count;
}

console.log("2 - Quantidade de impares: " + impares());

//3)
const inverse = () => { console.log("3 - Ordem inversa: " + numeros.reverse().concat()); }

inverse();

//4) 
function bigger () : number { return numeros.sort()[numeros.length - 1]; }

console.log("4 - Maior número: " + bigger());

//5) 
function smaller () : number { return numeros.sort()[0]; }
console.log("5 - Menor número: " + smaller());

//6)
function avarage () : number {
    let avg : number = 0;

    for (let item of numeros)
        avg += item;
    
    return avg / numeros.length;
}

console.log("6 - Média dos números: " + avarage());

// 7)
function ShowPares() {
    let count : number = 0;
    
    for (let item of numeros) 
        if(item % 2 == 0)
            count++;

    return count;
}
