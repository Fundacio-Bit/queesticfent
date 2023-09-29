package org.fundaciobit.queesticfent.back.test;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringEscapeUtils;
import org.fundaciobit.queesticfent.back.controller.user.Item;
import org.fundaciobit.queesticfent.back.controller.user.LlistatEntradesUserController;
import org.fundaciobit.queesticfent.back.controller.user.UserInfo;

/**
 * 
 * @author anadal
 *
 */
public class TesterODT {

    public static void main(String[] args) {
        File file = new File("D:\\Projectes\\queesticfent-fitxers\\plantilles\\OTAE_Template.odt");
        FileOutputStream out;
        try {
            out = new FileOutputStream(new File("output.odt"));

            List<UserInfo> usuaris = new ArrayList<>();

            for (int u = 0; u < 2; u++) {

                UserInfo ue = new UserInfo();

                ue.setNom("Francesc" + u);
                

                List<Item> items = new ArrayList<>();
                for (int i = 1; i < 31; i++) {
                    Item it = new Item();
                    it.setComentari("Comentari de Test-" + i);
                    it.setDia("" + i);
                    items.add(it);
                    ue.setItems(items);
                }

                usuaris.add(ue);
            }

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("usuaris", usuaris);
            map.put("mes", StringEscapeUtils.unescapeHtml("febrer"));
            map.put("any", String.valueOf(2022));

            //generateUserInfo(usuarisList, projecteID, any, mes);

            LlistatEntradesUserController.generateUsingXDocReport(map, file, out);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("XYZ ZZZ FINAL");
    }
}