import { Component, inject } from '@angular/core';
import {
  FormsModule,
  NonNullableFormBuilder,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { UsuarioService } from '../../services/usuario.service';
import { Router } from '@angular/router';
import { catchError, from, map, switchMap, take, tap, throwError } from 'rxjs';
import { AutentificacaoService } from '../../services/autentificacao.service';

@Component({
  selector: 'app-login',
  imports: [ReactiveFormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss',
})
export class LoginComponent {
  private router = inject(Router);
  private usuarioService = inject(UsuarioService);
  private formBuilder = inject(NonNullableFormBuilder);
  protected form = this.formBuilder.group({
    nomeLogin: ['', [Validators.required]],
    senha: ['', [Validators.required]],
  });
  private autentificacaoService = inject(AutentificacaoService)

  constructor(){
    console.log("constructor login component");

    from([1, 2, 3, 4, 5])
    .pipe(
      tap( (item) => console.log(`valor ${item}`)),
      map( (item) => {
        if (item == 0){
          throw new Error("Valor Zero")
        }
        return item;
      })
    ).subscribe({
      next: (item) => {
        console.log(`Valor do item: ${item}`)
      },
      error: (error) => console.log(error),
      complete: () => console.log("Fim")
    });
  }

  protected criarUsuario() {
    this.autentificacaoService
      .criarUsuario()
      .subscribe(
        (res: any) => {
          console.log(res);
          this.autentificacaoService.setTokens(res.accessToken, res.refreshToken);
        }
      );
  }

  protected login() {
    this.autentificacaoService
      .login()
      .subscribe((res) => console.log(res));
  }

  protected rotaPrivada() {
    this.autentificacaoService
      .rotaPrivada()
      .pipe(
        take(1),
        catchError((error) => {
          if (error.status !== 401) {
            return throwError(()=>error);
          }

          return this.autentificacaoService.refresh()
          .pipe(
            tap((res:any) => {
              this.autentificacaoService.setTokens(res.accessToken, res.refreshToken)
            }),
            switchMap(() => this.autentificacaoService.rotaPrivada())
          )
        })
      )
      .subscribe((res) => console.log(res));
  }

  protected async acessar() {
    console.log(this.form.value);
    await this.usuarioService.login(this.form.value);

    this.usuarioService.obterTodos().subscribe({
      next: (usuarios) => {
        console.log(usuarios);
      },
      error: (erro) => {
        console.log(erro);
      },
    });
    // this.router.navigate(['/cliente']);
  }

  buscarUsuarios() {
    this.usuarioService.obterTodos().subscribe({
      next: (usuarios) => {
        console.log(usuarios);
      },
      error: (erro) => {
        console.log(erro);
      },
    });
  }
}
