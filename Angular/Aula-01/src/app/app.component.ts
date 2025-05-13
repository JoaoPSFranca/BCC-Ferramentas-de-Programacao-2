import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { PostComponent } from './components/post/post.component';

@Component({
  selector: 'app-root',
  imports: [PostComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})

export class AppComponent {
  title = 'Aula-01';
}
