package api;

import com.example.stuffrentservice.StuffrentserviceApplication;
import javassist.NotFoundException;

import lombok.RequiredArgsConstructor;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import services.IStuffRentService;
import services.models.Stuff;

import java.util.List;

@RestController
@RequestMapping("api/swimmingstuff")
@RequiredArgsConstructor
public final class StuffRentController {

  static final Logger log = LoggerFactory.getLogger(StuffrentserviceApplication.class);

  @Autowired private IStuffRentService swimmingStuffService;

  @GetMapping
  public ResponseEntity<List<Stuff>> index() {

    return ResponseEntity.ok(swimmingStuffService.findAll());
  }

  @PostMapping
  public ResponseEntity<Stuff> create(@RequestBody StuffPayload payload) {

    Stuff newSwimmingStuff = new Stuff(payload.getType(), payload.getPrice());

    return ResponseEntity.ok(swimmingStuffService.save(newSwimmingStuff));
  }

  @GetMapping("/{swimmingstuffId}")
  public ResponseEntity<Stuff> show(@PathVariable String swimmingstuffId) throws NotFoundException {

    return ResponseEntity.ok(swimmingStuffService.getById(swimmingstuffId));
  }

  @DeleteMapping("/{swimmingstuffId}")
  public ResponseEntity<Void> delete(@PathVariable String swimmingstuffId)
      throws NotFoundException {

    swimmingStuffService.deleteById(swimmingstuffId);

    return ResponseEntity.noContent().build();
  }
}
