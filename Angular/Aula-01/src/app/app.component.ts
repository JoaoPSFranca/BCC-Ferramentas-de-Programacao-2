import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ClienteComponent } from './components/cliente/cliente.component';

@Component({
  selector: 'app-root',
  imports: [ClienteComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})

export class AppComponent {
  title = 'Aula-01';
}
