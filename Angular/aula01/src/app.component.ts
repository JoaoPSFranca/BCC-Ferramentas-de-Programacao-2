import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';

@Component({
    selector: 'app-root',
    imports: ['RouterModule'],
    templateUrl: './app.component.html',
    styleUrls: './app.component.scss'
})
export class AppComponent {
    protected tittle = 'aula-01';
    protected nomeCompleto:string = "JotaPe";

    constructor(){}

    alterarNome() {
        this.nomeCompleto = 'JotaPe';
    }

    getNomeCompleto(){
        this.exibir();
        return this.nomeCompleto;
    }

    nomes = ['Jota', 'Pe', 'JotaPe'];

    exibir(){
        console.log(this.nomeCompleto);
    }
}