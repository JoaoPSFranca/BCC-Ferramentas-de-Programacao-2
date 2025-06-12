import { inject, Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor,
} from '@angular/common/http';
import { Observable } from 'rxjs';
import { UsuarioService } from '../services/usuario.service';
import { AutentificacaoService } from '../services/autentificacao.service';

@Injectable()
export class AutenticacaoInterceptor implements HttpInterceptor {
  private autentificacaoService = inject(AutentificacaoService);
  private usuarioService = inject(UsuarioService);
  constructor() {}

  intercept(
    request: HttpRequest<unknown>,
    next: HttpHandler
  ): Observable<HttpEvent<unknown>> {
    const userToken = this.usuarioService.getToken();
    if (userToken) {
      request = request.clone({
        setHeaders: { Authorization: `Bearer ${userToken}` },
      });
    }

    const authToken = this.autentificacaoService.getAccessToken();
    if (authToken) {
      request = request.clone({
        setHeaders: { Authorization: `Bearer ${authToken}` },
      });
    }
    
    return next.handle(request);
  }
}
