package org.transport.TP.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.transport.TP.metier.InterfaceMetier;

@Controller
@SessionAttributes("cargaisons")
public class TransportControleur {

	@Autowired
	private InterfaceMetier IM;

	/****
	 * 
	 * @param model
	 * @return
	 */
	// envoyer tous les cargaisons a la page index pour charger tous a l'ouverture
	// dans la formulaire 1
	@RequestMapping(value = "/index")
	public String index(Model model) {
		model.addAttribute("cargaisons", IM.getTousCargaison());
		return "Transport";
	}

	/****
	 * 
	 * @param refCarg
	 * @param model
	 * @return
	 */
	// recupere les attribut de la formulaire 1 pour afficher un marchandise d'apres
	// un cargaison
	@RequestMapping(value = "/marchandiseParCarg")
	public String marchandiseParCarg(@RequestParam(value = "refCarg") String refCarg, Model model) {
		// recupere est stocker les attributs du l'url
		model.addAttribute("refcarg", refCarg);
		model.addAttribute("marchandises", IM.getMarchandiseCargaison(refCarg));
		// model.addAttribute("cargaisons", IM.getTousCargaison());
		return "Transport";
	}

	/***
	 * 
	 * @param idmarch
	 * @param model
	 * @return
	 */
	// supprimer un marchandise
	// recupere les attribut de la formulaire 1 pour afficher un marchandise d'apres
	// un cargaison
	@RequestMapping(value = "/supprimer")
	public String supprimerMarchandise(@RequestParam(value = "idMarch") Long idmarch, Model model) {
		// recupere est stocker les attributs du l'url
		model.addAttribute("idmarch", idmarch);
		IM.supprilmerMarchandise(idmarch);
		model.addAttribute("marchandises", IM.getMarchandiseMotcle(""));
		// model.addAttribute("cargaisons", IM.getTousCargaison());
		return "Transport";
	}

	/****
	 * 
	 * @param mc
	 * @param model
	 * @return
	 */
	// choisir le nom du fichier ou se trouve le traitement extension .do
	@RequestMapping(value = "/cherche")
	// recupere les attribut dans url
	public String cherche(@RequestParam(value = "motcle") String mc, Model model) {
		model.addAttribute("mc", mc);
		model.addAttribute("marchandises", IM.getMarchandiseMotcle(mc));
		// model.addAttribute("cargaisons", IM.getTousCargaison());
		// returne a la page du Vue transport.jsp
		return "Transport";
	}
}
