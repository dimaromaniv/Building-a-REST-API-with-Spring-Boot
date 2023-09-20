package example.cashcard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;


@RestController
@RequestMapping("/cashcards")
public class CashCardController {
    @Autowired
    private CashCardRepository cashCardRepository;

    public CashCardController(CashCardRepository cashCardRepository){
        this.cashCardRepository = cashCardRepository;
    }

//    @GetMapping(value = "/{id}")
//    public ResponseEntity<CashCard> findById(@PathVariable Long id) {
//        if (id.equals(99L)) {
//            CashCard cashCard = new CashCard(99L, 123.45);
//            return ResponseEntity.ok(cashCard);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<CashCard> findById (@PathVariable Long id) {
        Optional<CashCard> cashCardOptional = cashCardRepository.findById(id);
        if (cashCardOptional.isPresent()) {
            return ResponseEntity.ok(cashCardOptional.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

}


