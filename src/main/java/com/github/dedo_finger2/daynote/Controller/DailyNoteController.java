package com.github.dedo_finger2.daynote.Controller;

import com.github.dedo_finger2.daynote.Model.DailyNote;
import com.github.dedo_finger2.daynote.Model.Note;
import com.github.dedo_finger2.daynote.Response.*;
import com.github.dedo_finger2.daynote.Service.DailyNoteService;
import com.github.dedo_finger2.daynote.Service.Exception.ResourceConflict;
import com.github.dedo_finger2.daynote.Service.Exception.ResourceNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/daily-notes")
public class DailyNoteController {
    @Autowired
    private DailyNoteService dailyNoteService;

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<ResponseCollection<DailyNote>> getALl() {
        List<DailyNote> dailyNotes = this.dailyNoteService.getAll();

        ResponseCollection<DailyNote> body = new ResponseCollection<>();
        body.setStatus(HttpStatus.OK);
        body.setMessage("success");
        body.setData(dailyNotes);

        return ResponseEntity.ok(body);
    }

    @GetMapping(path = "/{id}/notes")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<?> getNotesById(@PathVariable String id) {
        try {
            List<Note> dailyNoteNotes = this.dailyNoteService.getNotesById(Long.parseLong(id));

            ResponseCollection<Note> responseBody = new ResponseCollection<>();
            responseBody.setStatus(HttpStatus.OK);
            responseBody.setMessage("success");
            responseBody.setData(dailyNoteNotes);

            return ResponseEntity.status(responseBody.getStatus()).body(responseBody);
        } catch (ResourceNotFound e) {
            BaseResponse responseBody = new BaseResponse();
            responseBody.setStatus(HttpStatus.NOT_FOUND);
            responseBody.setMessage("daily note not found");

            return ResponseEntity.status(responseBody.getStatus()).body(responseBody);
        } catch (NumberFormatException e) {
            BaseResponse responseBody = new BaseResponse();
            responseBody.setStatus(HttpStatus.BAD_REQUEST);
            responseBody.setMessage("invalid id format");

            return ResponseEntity.status(responseBody.getStatus()).body(responseBody);
        } catch (Exception e) {
            ResponseInternalServerError responseBody = new ResponseInternalServerError();
            System.out.println(e.getMessage());

            return ResponseEntity.status(responseBody.getStatus()).body(responseBody);
        }
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<?> getById(@PathVariable String id) {
        try {
            Optional<DailyNote> dailyNote = this.dailyNoteService.getById(Long.parseLong(id));

            return ResponseEntity.ok().body(dailyNote);
        } catch (ResourceNotFound e) {
            BaseResponse responseBody = new BaseResponse();
            responseBody.setStatus(HttpStatus.NOT_FOUND);
            responseBody.setMessage("daily note not found");

            return ResponseEntity.status(responseBody.getStatus()).body(responseBody);
        } catch (NumberFormatException e) {
            BaseResponse responseBody = new BaseResponse();
            responseBody.setStatus(HttpStatus.BAD_REQUEST);
            responseBody.setMessage("invalid id format");

            return ResponseEntity.status(responseBody.getStatus()).body(responseBody);
        } catch (Exception e) {
            ResponseInternalServerError responseBody = new ResponseInternalServerError();

            return ResponseEntity.status(responseBody.getStatus()).body(responseBody);
        }
    }

    @GetMapping(path = "/title/{title}")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<?> getByTitle(@PathVariable String title) {
        try {
            Optional<DailyNote> dailyNote = this.dailyNoteService.getByTitle(LocalDate.parse(title));

            return ResponseEntity.ok().body(dailyNote);
        } catch (ResourceNotFound e) {
            BaseResponse responseBody = new BaseResponse();
            responseBody.setStatus(HttpStatus.NOT_FOUND);
            responseBody.setMessage("daily note not found");

            return ResponseEntity.status(responseBody.getStatus()).body(responseBody);
        } catch (DateTimeParseException e) {
            BaseResponse responseBody = new BaseResponse();
            responseBody.setStatus(HttpStatus.BAD_REQUEST);
            responseBody.setMessage("invalid title format");

            return ResponseEntity.status(responseBody.getStatus()).body(responseBody);
        } catch (Exception e) {
            ResponseInternalServerError responseBody = new ResponseInternalServerError();

            return ResponseEntity.status(responseBody.getStatus()).body(responseBody);
        }
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<?> createTodayDailyNote() {
        try {
            DailyNote dailyNote = this.dailyNoteService.create();

            CreatedDailyNoteResponse responseBody = new CreatedDailyNoteResponse();
            responseBody.setId(dailyNote.getId());

            return ResponseEntity.status(responseBody.getStatus()).body(responseBody);
        } catch (ResourceConflict e) {
            BaseResponse responseBody = new BaseResponse();
            responseBody.setStatus(HttpStatus.CONFLICT);
            responseBody.setMessage("today's daily note already exists");

            return ResponseEntity.status(responseBody.getStatus()).body(responseBody);
        } catch (Exception e) {
            ResponseInternalServerError body = new ResponseInternalServerError();
            return ResponseEntity.status(body.getStatus()).body(body);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public ResponseEntity<?> deleteDailyNoteById(@PathVariable String id) {
        try {
            this.dailyNoteService.deleteById(Long.parseLong(id));

            return null;
        } catch (ResourceNotFound e) {
            BaseResponse responseBody = new BaseResponse();
            responseBody.setStatus(HttpStatus.NOT_FOUND);
            responseBody.setMessage("daily note not found");

            return ResponseEntity.status(responseBody.getStatus()).body(responseBody);
        } catch (NumberFormatException e) {
            BaseResponse responseBody = new BaseResponse();
            responseBody.setStatus(HttpStatus.BAD_REQUEST);
            responseBody.setMessage("invalid id format");

            return ResponseEntity.status(responseBody.getStatus()).body(responseBody);
        } catch (Exception e) {
            ResponseInternalServerError responseBody = new ResponseInternalServerError();

            return ResponseEntity.status(responseBody.getStatus()).body(responseBody);
        }
    }
}
