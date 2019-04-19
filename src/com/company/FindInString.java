package com.company;

/**
 * @author dkorolev
 *         Date: 4/19/2019
 *         Time: 3:56 PM
 */
public class FindInString {

    public static void main(String[] args) {
        String str = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "    <head>\n" +
                "        <style type=\"text/css\">\n" +
                "            td,th {\n" +
                "                padding-left: 10pt;\n" +
                "                padding-right: 10pt;\n" +
                "            }\n" +
                "            table {\n" +
                "                padding: 2pt;\n" +
                "                text-align: center;\n" +
                "            }\n" +
                "            .section{\n" +
                "                margin-bottom: 10pt;\n" +
                "                margin-left: 5pt;\n" +
                "            }\n" +
                "            .checks-list{\n" +
                "                list-style: none;\n" +
                "                padding-left:0;\n" +
                "            }\n" +
                "            .general-info{\n" +
                "                list-style: none;\n" +
                "                padding-left:0;\n" +
                "            }\n" +
                "        </style>\n" +
                "    </head>\n" +
                "  <body style=\"font-family: monospace\">\n" +
                "\n" +
                "\n" +
                "<ul class=\"general-info\">\n" +
                "    <li><span style=\"background-color: #80FF80; \">sbb access</span>\n" +
                "    <li>POD name: $podName\n" +
                "    <li>Build version: 1.20.0-SNAPSHOT.0d06fc8\n" +
                "    <li>Stammdaten schema version: 1.20.0\n" +
                "    <li>Nova versions: []\n" +
                "    <li>Nova version URL aliases: []\n" +
                "    <li>Database info: jdbc:oracle:thin:@test-env1.sbb.t-systems.ru:1521:te1,ZPS_DKO_TX,13.104.0\n" +
                "    <li>Server time: 19.04.2019 15:37:23\n" +
                "    <li>Server started: 18.04.2019 14:48:04\n" +
                "    <li>CheckLevel: SYSINFO\n" +
                "    <li>Time consumed:  n/a    <li>Check statistics: doCheck calls/failures: 14/0, thread pool " +
                "size/active: 7/0\n" +
                "    <li>status: <span style=\"background-color: #80FF80; \">UP</span></ul>\n" +
                "\n" +
                "<div class=\"section\">\n" +
                "Datenreleases:\n" +
                "<table>\n" +
                "    <tbody>\n" +
                "        <tr>\n" +
                "            <th>Datenrelease id</th>\n" +
                "            <th width=\"75px\">GueltigAb</th>\n" +
                "            <th>GueltigBis</th>\n" +
                "            <th>Beschreibung</th>\n" +
                "            <th>zuLaden</th>\n" +
                "        </tr>\n" +
                "\n" +
                "                <tr>\n" +
                "          <td>106-SNAPSHOT.20190404-1310.T.T.001.0</td>\n" +
                "          <td>13.12.2017</td>\n" +
                "          <td>31.12.9999</td>\n" +
                "          <td> null </td>\n" +
                "          <td>true</td>\n" +
                "        </tr>\n" +
                "            </tbody>\n" +
                "</table>\n" +
                "</div>\n" +
                "\n" +
                "<div class=\"section\">\n" +
                "Vertriebskonfigurationen:\n" +
                "<table>\n" +
                "    <tbody>\n" +
                "        <tr>\n" +
                "            <th>VK id</th>\n" +
                "            <th width=\"75px\">GueltigAb</th>\n" +
                "            <th>GueltigBis</th>\n" +
                "            <th>zuLaden</th>\n" +
                "        </tr>\n" +
                "\n" +
                "                <tr>\n" +
                "          <td>VK_106-SNAPSHOT.20190404-1310.T.T.001.0_BLS-bls_971</td>\n" +
                "          <td>13.12.2017</td>\n" +
                "          <td>31.12.9999</td>\n" +
                "          <td>true</td>\n" +
                "        </tr>\n" +
                "                <tr>\n" +
                "          <td>VK_106-SNAPSHOT.20190404-1310.T.T.001.0_BLS-brs_960</td>\n" +
                "          <td>13.12.2017</td>\n" +
                "          <td>31.12.9999</td>\n" +
                "          <td>true</td>\n" +
                "        </tr>\n" +
                "                <tr>\n" +
                "          <td>VK_106-SNAPSHOT.20190404-1310.T.T.001.0_BLS-gbs_959</td>\n" +
                "          <td>13.12.2017</td>\n" +
                "          <td>31.12.9999</td>\n" +
                "          <td>true</td>\n" +
                "        </tr>\n" +
                "                <tr>\n" +
                "          <td>VK_106-SNAPSHOT.20190404-1310.T.T.001.0_BLS-ths_960</td>\n" +
                "          <td>13.12.2017</td>\n" +
                "          <td>31.12.9999</td>\n" +
                "          <td>true</td>\n" +
                "        </tr>\n" +
                "                <tr>\n" +
                "          <td>VK_106-SNAPSHOT.20190404-1310.T.T.001.0_BSU_957</td>\n" +
                "          <td>13.12.2017</td>\n" +
                "          <td>31.12.9999</td>\n" +
                "          <td>true</td>\n" +
                "        </tr>\n" +
                "                <tr>\n" +
                "          <td>VK_106-SNAPSHOT.20190404-1310.T.T.001.0_PAG_974</td>\n" +
                "          <td>13.12.2017</td>\n" +
                "          <td>31.12.9999</td>\n" +
                "          <td>true</td>\n" +
                "        </tr>\n" +
                "                <tr>\n" +
                "          <td>VK_106-SNAPSHOT.20190404-1310.T.T.001.0_PAG_978</td>\n" +
                "          <td>13.12.2017</td>\n" +
                "          <td>31.12.9999</td>\n" +
                "          <td>true</td>\n" +
                "        </tr>\n" +
                "                <tr>\n" +
                "          <td>VK_106-SNAPSHOT.20190404-1310.T.T.001.0_RBS_957</td>\n" +
                "          <td>13.12.2017</td>\n" +
                "          <td>31.12.9999</td>\n" +
                "          <td>true</td>\n" +
                "        </tr>\n" +
                "                <tr>\n" +
                "          <td>VK_106-SNAPSHOT.20190404-1310.T.T.001.0_SBB_1006</td>\n" +
                "          <td>13.12.2017</td>\n" +
                "          <td>31.12.9999</td>\n" +
                "          <td>true</td>\n" +
                "        </tr>\n" +
                "                <tr>\n" +
                "          <td>VK_106-SNAPSHOT.20190404-1310.T.T.001.0_SBB_41</td>\n" +
                "          <td>13.12.2017</td>\n" +
                "          <td>31.12.9999</td>\n" +
                "          <td>true</td>\n" +
                "        </tr>\n" +
                "                <tr>\n" +
                "          <td>VK_106-SNAPSHOT.20190404-1310.T.T.001.0_SBB_42</td>\n" +
                "          <td>13.12.2017</td>\n" +
                "          <td>31.12.9999</td>\n" +
                "          <td>true</td>\n" +
                "        </tr>\n" +
                "                <tr>\n" +
                "          <td>VK_106-SNAPSHOT.20190404-1310.T.T.001.0_SBB_43</td>\n" +
                "          <td>13.12.2017</td>\n" +
                "          <td>31.12.9999</td>\n" +
                "          <td>true</td>\n" +
                "        </tr>\n" +
                "                <tr>\n" +
                "          <td>VK_106-SNAPSHOT.20190404-1310.T.T.001.0_SBB_45</td>\n" +
                "          <td>13.12.2017</td>\n" +
                "          <td>31.12.9999</td>\n" +
                "          <td>true</td>\n" +
                "        </tr>\n" +
                "                <tr>\n" +
                "          <td>VK_106-SNAPSHOT.20190404-1310.T.T.001.0_SBB_46</td>\n" +
                "          <td>13.12.2017</td>\n" +
                "          <td>31.12.9999</td>\n" +
                "          <td>true</td>\n" +
                "        </tr>\n" +
                "                <tr>\n" +
                "          <td>VK_106-SNAPSHOT.20190404-1310.T.T.001.0_SBB_916</td>\n" +
                "          <td>13.12.2017</td>\n" +
                "          <td>31.12.9999</td>\n" +
                "          <td>true</td>\n" +
                "        </tr>\n" +
                "                <tr>\n" +
                "          <td>VK_106-SNAPSHOT.20190404-1310.T.T.001.0_SBB_954</td>\n" +
                "          <td>13.12.2017</td>\n" +
                "          <td>31.12.9999</td>\n" +
                "          <td>true</td>\n" +
                "        </tr>\n" +
                "                <tr>\n" +
                "          <td>VK_106-SNAPSHOT.20190404-1310.T.T.001.0_SBB_994</td>\n" +
                "          <td>13.12.2017</td>\n" +
                "          <td>31.12.9999</td>\n" +
                "          <td>true</td>\n" +
                "        </tr>\n" +
                "                <tr>\n" +
                "          <td>VK_106-SNAPSHOT.20190404-1310.T.T.001.0_SBB_998</td>\n" +
                "          <td>13.12.2017</td>\n" +
                "          <td>31.12.9999</td>\n" +
                "          <td>true</td>\n" +
                "        </tr>\n" +
                "                <tr>\n" +
                "          <td>VK_106-SNAPSHOT.20190404-1310.T.T.001.0_SVB-Auto_924</td>\n" +
                "          <td>13.12.2017</td>\n" +
                "          <td>31.12.9999</td>\n" +
                "          <td>true</td>\n" +
                "        </tr>\n" +
                "                <tr>\n" +
                "          <td>VK_106-SNAPSHOT.20190404-1310.T.T.001.0_TL-lo_977</td>\n" +
                "          <td>13.12.2017</td>\n" +
                "          <td>31.12.9999</td>\n" +
                "          <td>true</td>\n" +
                "        </tr>\n" +
                "                <tr>\n" +
                "          <td>VK_106-SNAPSHOT.20190404-1310.T.T.001.0_TL_977</td>\n" +
                "          <td>13.12.2017</td>\n" +
                "          <td>31.12.9999</td>\n" +
                "          <td>true</td>\n" +
                "        </tr>\n" +
                "                <tr>\n" +
                "          <td>VK_106-SNAPSHOT.20190404-1310.T.T.001.0_TPF_970</td>\n" +
                "          <td>13.12.2017</td>\n" +
                "          <td>31.12.9999</td>\n" +
                "          <td>true</td>\n" +
                "        </tr>\n" +
                "                <tr>\n" +
                "          <td>VK_106-SNAPSHOT.20190404-1310.T.T.001.0_TPG_980</td>\n" +
                "          <td>13.12.2017</td>\n" +
                "          <td>31.12.9999</td>\n" +
                "          <td>true</td>\n" +
                "        </tr>\n" +
                "                <tr>\n" +
                "          <td>VK_106-SNAPSHOT.20190404-1310.T.T.001.0_ZPS-TEST-LV_1000</td>\n" +
                "          <td>13.12.2017</td>\n" +
                "          <td>31.12.9999</td>\n" +
                "          <td>true</td>\n" +
                "        </tr>\n" +
                "                <tr>\n" +
                "          <td>VK_106-SNAPSHOT.20190404-1310.T.T.001.0_ZPS-TEST-LV_1001</td>\n" +
                "          <td>13.12.2017</td>\n" +
                "          <td>31.12.9999</td>\n" +
                "          <td>true</td>\n" +
                "        </tr>\n" +
                "                <tr>\n" +
                "          <td>VK_106-SNAPSHOT.20190404-1310.T.T.001.0_ZPS-TEST-LV_1007</td>\n" +
                "          <td>13.12.2017</td>\n" +
                "          <td>31.12.9999</td>\n" +
                "          <td>true</td>\n" +
                "        </tr>\n" +
                "                <tr>\n" +
                "          <td>VK_106-SNAPSHOT.20190404-1310.T.T.001.0_ZPS-TEST-LV_1008</td>\n" +
                "          <td>13.12.2017</td>\n" +
                "          <td>31.12.9999</td>\n" +
                "          <td>true</td>\n" +
                "        </tr>\n" +
                "                <tr>\n" +
                "          <td>VK_106-SNAPSHOT.20190404-1310.T.T.001.0_ZPS-TEST-LV_996</td>\n" +
                "          <td>13.12.2017</td>\n" +
                "          <td>31.12.9999</td>\n" +
                "          <td>true</td>\n" +
                "        </tr>\n" +
                "                <tr>\n" +
                "          <td>VK_106-SNAPSHOT.20190404-1310.T.T.001.0_ZPS-TEST-LV_997</td>\n" +
                "          <td>13.12.2017</td>\n" +
                "          <td>31.12.9999</td>\n" +
                "          <td>true</td>\n" +
                "        </tr>\n" +
                "                <tr>\n" +
                "          <td>VK_106-SNAPSHOT.20190404-1310.T.T.001.0_ZPS-TEST-LV_998</td>\n" +
                "          <td>13.12.2017</td>\n" +
                "          <td>31.12.9999</td>\n" +
                "          <td>true</td>\n" +
                "        </tr>\n" +
                "                <tr>\n" +
                "          <td>VK_106-SNAPSHOT.20190404-1310.T.T.001.0_ZPS-TEST-LV_999</td>\n" +
                "          <td>13.12.2017</td>\n" +
                "          <td>31.12.9999</td>\n" +
                "          <td>true</td>\n" +
                "        </tr>\n" +
                "                <tr>\n" +
                "          <td>VK_106-SNAPSHOT.20190404-1310.T.T.001.0_ZVV_976</td>\n" +
                "          <td>13.12.2017</td>\n" +
                "          <td>31.12.9999</td>\n" +
                "          <td>true</td>\n" +
                "        </tr>\n" +
                "            </tbody>\n" +
                "</table>\n" +
                "</div>\n" +
                "\n" +
                "\n" +
                "<div class=\"section\">\n" +
                "    Subsystems:\n" +
                "    <ul>\n" +
                "            <li> Subsystem: NETZ <ul>\n" +
                "                                <li>[Circuit breaker] name: HAFAS, status: CLOSED, error/opened " +
                "count: 0/0.\n" +
                "                            </ul>\n" +
                "        </ul>\n" +
                "</div>\n" +
                "\n" +
                "  </body>\n" +
                "</html>";


        int startDRId = str.indexOf("<td>");
        int endDRid = str.indexOf("</td>");
        String drId = str.substring(startDRId+4,endDRid);
        System.out.println(drId);
    }
}