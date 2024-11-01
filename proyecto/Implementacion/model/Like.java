import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Like {

    @Id
    @GeneratedValue
    private Long idLike;
    private Boolean anonimoLike;

    @ManyToOne
    private Publicacion publicacion;

    //Constructor con parámetros para los atributos principales
    public Like(Boolean anonimo) {
        this.anonimoLike = anonimo;
    }

    //Método para eliminar el like
    public void eliminarLike() {
        if (publicacion != null) {
            publicacion.getLikes().remove(this);
            this.publicacion = null;
        }
    }

    // Método para cambiar el anonimato del like
    public void cambiarAnonimatoLike(Boolean anonimo) {
        this.anonimoLike = anonimo;
    }
}
