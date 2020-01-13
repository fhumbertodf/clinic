package com.example.web;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponents;

import com.example.domain.Pet;
import com.example.service.PetService;

public class PetController {

	/**
	 * TODO Auto-generated attribute documentation
	 *
	 */
	private PetService petService;
	
	 /**
     * TODO Auto-generated method documentation
     *
     * @param binder
     */
    @InitBinder("pet")
    public void initPetBinder(WebDataBinder binder) {
        binder.setDisallowedFields("id");       
    }
    
    @PostMapping(name = "create")
    public ModelAndView create(@Valid @ModelAttribute Pet pet, BindingResult result, Model model) {
        if (result.hasErrors()) {
            populateForm(model);
            return new ModelAndView("pets/create");
        }
        Pet newPet = petService.save(pet);
        UriComponents showURI = getItemLink().to(PetsItemThymeleafLinkFactory.SHOW).with("pet", newPet.getId()).toUri();
        return new ModelAndView("redirect:" + showURI.toUriString());
    }
    
    @GetMapping(value = "/create-form", name = "createForm")
    public ModelAndView createForm(Model model) {
        populateForm(model);
        model.addAttribute("pet", new Pet());
        return new ModelAndView("pets/create");
    }
    
    @ModelAttribute
    public Pet getPet(@PathVariable("pet") Long id, Locale locale, HttpMethod method) {
        Pet pet = null;
        if (HttpMethod.PUT.equals(method)) {
            pet = petService.findOneForUpdate(id);
        } else {
            pet = petService.findOne(id);
        }
        if (pet == null) {
            String message = messageSource.getMessage("error_NotFound", new Object[] { "Pet", id }, "The record couldn't be found", locale);
            throw new NotFoundException(message);
        }
        return pet;
    }
    
    @GetMapping(name = "show")
    public ModelAndView show(@ModelAttribute Pet pet, Model model) {
        model.addAttribute("pet", pet);
        return new ModelAndView("pets/show");
    }
    
    @GetMapping(value = "/edit-form", name = "editForm")
    public ModelAndView editForm(@ModelAttribute Pet pet, Model model) {
        populateForm(model);
        model.addAttribute("pet", pet);
        return new ModelAndView("pets/edit");
    }
    
    @PutMapping(name = "update")
    public ModelAndView update(@Valid @ModelAttribute Pet pet, BindingResult result, @RequestParam("version") Integer version, @RequestParam(value = "concurrency", required = false, defaultValue = "") String concurrencyControl, Model model) {
        // Check if provided form contain errors
        if (result.hasErrors()) {
            populateForm(model);
            return new ModelAndView(getEditViewPath());
        }
        // Create Concurrency Spring Template to ensure that the following code will manage the
        // possible concurrency exceptions that appears and execute the provided coded inside the Spring template.
        // If some concurrency exception appears the template will manage it.
        Pet savedPet = getConcurrencyTemplate().execute(pet, model, new ConcurrencyCallback<Pet>() {

            @Override
            public Pet doInConcurrency(Pet pet) throws Exception {
                return petService.save(pet);
            }
        });
        UriComponents showURI = getItemLink().to(PetsItemThymeleafLinkFactory.SHOW).with("pet", savedPet.getId()).toUri();
        return new ModelAndView("redirect:" + showURI.toUriString());
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param pet
     * @return ResponseEntity
     */
    @ResponseBody
    @DeleteMapping(name = "delete")
    public ResponseEntity<?> delete(@ModelAttribute Pet pet) {
    	petService.delete(pet);
        return ResponseEntity.ok().build();
    }

}
