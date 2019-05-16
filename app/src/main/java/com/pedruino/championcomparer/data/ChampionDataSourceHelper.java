package com.pedruino.championcomparer.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChampionDataSourceHelper {
    public List<Champion> getDataSource() {
        return dataSource;
    }

    private List<Champion> dataSource;

    public ChampionDataSourceHelper() {
        this.dataSource = new ArrayList<>();

        String aniviaLore = "Anivia is a benevolent winged spirit who endures endless cycles of life, death, and rebirth to protect the Freljord. A demigod born of unforgiving ice and bitter winds, she wields those elemental powers to thwart any who dare disturb her homeland. Anivia guides and protects the tribes of the harsh north, who revere her as a symbol of hope, and a portent of great change. She fights with every ounce of her being, knowing that through her sacrifice, her memory will endure, and she will be reborn into a new tomorrow.";
        Champion anivia = new Champion("Anivia", "the Cryophoenix", aniviaLore, "anivia",
                new Champion.Info(1, 4, 10, 10),
                Arrays.asList(
                        new Champion.Passive("Rebirth", "Upon dying, Anivia will revert into an egg. If the egg can survive for six seconds, she is gloriously reborn.",
                                "anivia_passive"),
                        new Champion.Spell("Flash Frost", "80/90/100/110/120", "10/9.5/9/8.5/8",
                                "Anivia brings her wings together and summons a sphere of ice that flies towards her opponents, chilling and damaging anyone in its path. When the sphere explodes it does moderate damage in a radius, stunning anyone in the area.",
                                "A massive chunk of ice flies toward target location, dealing {{ e1 }} <scaleAP>(+{{ a1 }})</scaleAP> magic damage. <br /><br />At the end of its range or if Anivia activates the spell again, the missile detonates, doing {{ e1 }} <scaleAP>(+{{ a1 }})</scaleAP> magic damage in a small area and stunning units for {{ e4 }} seconds.<br /><br />Enemies damaged by Flash Frost are also slowed by {{ f1 }}% for {{ e5 }} seconds.",
                                "anivia_spell_flash_frost"),
                        new Champion.Spell("Crystallize", "70", "17",
                                "Anivia condenses the moisture in the air into an impassable wall of ice to block all movement. The wall only lasts a short duration before it melts.",
                                "Anivia summons an impassable wall of ice {{ e2 }} units wide, blocking all movement. The wall lasts for {{ e1 }} seconds before it melts.",
                                "anivia_spell_crystallize"),
                        new Champion.Spell("Frostbite", "50/60/70/80/90", "4",
                                "With a flap of her wings, Anivia blasts a freezing gust of wind at her target, dealing a low amount of damage. If the target was recently stunned by Flash Frost or damaged by a fully formed Glacial Storm, the damage they take is doubled.",
                                "Anivia blasts her target with a freezing wind, dealing {{ e1 }} <scaleAP>(+{{ a1 }})</scaleAP> magic damage. <br /><br />If a target was recently stunned by Anivia or damaged by a fully formed Glacial Storm, they take double damage.",
                                "anivia_spell_frostbite"),
                        new Champion.Spell("Glacial Storm", "75", "6",
                                "Anivia summons a driving rain of ice and hail to damage her enemies and slow their advance.",
                                "<spellPassive>Activate: </spellPassive>Drains <mana>{{ manacostpersecond }} Mana</mana> per second. <br /><br />Anivia calls forth a driving rain of ice and hail that increases in size over {{ growthtime }} seconds, dealing <magicDamage>{{ totaldamagepersecond }} magic damage</magicDamage> per second to targets and slowing their Movement Speed by {{ slowamount }}%. <br /><br />When the Glacial Storm is fully formed, it slows targets' Movement Speed by {{ enhancedslow }}% and does {{ bonusmultiplier }}% damage instead.",
                                "anivia_spell_glacial_storm")),
                getSkins("anivia"));

        String luxLore = "Luxanna Crownguard hails from Demacia, an insular realm where magical abilities are viewed with fear and suspicion. Able to bend light to her will, she grew up dreading discovery and exile, and was forced to keep her power secret, in order to preserve her family's noble status. Nonetheless, Lux's optimism and resilience have led her to embrace her unique talents, and she now covertly wields them in service of her homeland.";
        Champion lux = new Champion("Lux", "the Lady of Luminosity", luxLore, "lux",
                new Champion.Info(2, 4, 9, 5),
                Arrays.asList(
                        new Champion.Passive("Illumination", "Lux's damaging spells charge the target with energy for 6 seconds. Lux's next attack ignites the energy, dealing bonus magic damage (depending on Lux's level) to the target.",
                                "lux_passive_illuminating_fraulein"),
                        new Champion.Spell("Light Binding", "40/45/50/55/60", "10",
                                "Lux releases a sphere of light that binds and deals damage to up to two enemy units.",
                                "Fires a ball of light, rooting up to two enemies for {{ e3 }} seconds and dealing {{ e1 }} <scaleAP>(+{{ a1 }})</scaleAP> magic damage to each.",
                                "lux_spell_light_binding"),
                        new Champion.Spell("Prismatic Barrier", "60", "14/13/12/11/10",
                                "Lux releases a sphere of light that binds and deals damage to up to two enemy units.",
                                "Fires a ball of light, rooting up to two enemies for {{ e3 }} seconds and dealing {{ e1 }} <scaleAP>(+{{ a1 }})</scaleAP> magic damage to each.",
                                "lux_spell_prismatic_wave"),
                        new Champion.Spell("Lucent Singularity", "70/80/90/100/110", "10/9.5/9/8.5/8",
                                "Lux releases a sphere of light that binds and deals damage to up to two enemy units.",
                                "Fires a ball of light, rooting up to two enemies for {{ e3 }} seconds and dealing {{ e1 }} <scaleAP>(+{{ a1 }})</scaleAP> magic damage to each.",
                                "lux_spell_light_strike_kugel"),
                        new Champion.Spell("Final Spark", "100", "80/65/50",
                                "Lux releases a sphere of light that binds and deals damage to up to two enemy units.",
                                "Fires a ball of light, rooting up to two enemies for {{ e3 }} seconds and dealing {{ e1 }} <scaleAP>(+{{ a1 }})</scaleAP> magic damage to each.",
                                "lux_spell_malice_cannon")),
                getSkins("lux"));

        String nidaleeLore = "There are few dwellers, let alone champions, residing in the blasted and dangerous lands that lie south of the Great Barrier. Much of that world still bears the scars of past Runes Wars, especially the mysterious Kumungu Jungle. There are long-forgotten treasures in these strange places which many risk life and limb to acquire. Nidalee was only a young girl travelling with her treasure-seeking parents when they lost their way in the dense, rainy jungles. The jungle was unforgiving, and she watched her parents suffer agonizing final days as they fell victim to a mysterious and vicious disease.<br><br>As improbable as it was for a child to survive in the inhospitable jungle by herself, she did just that. Her youthful innocence and a fortunate naivete caused her to appeal to the beasts of that place and she was taken in by a family of cougars and raised as one of their own. She grew and somehow absorbed the raw magic of the dense wilds, evolving beyond both her human physiology and her feline affectation. Now a fierce, nigh-mythical protector,  Nidalee battles  viciously tooth and nail against any who would threaten the vast jungle she calls home.";
        Champion nidalee = new Champion("Nidalee", "the Bestial Huntress", nidaleeLore, "nidalee",
                new Champion.Info(5, 4, 7, 8), Arrays.asList(
                new Champion.Passive("Prowl", "Moving through brush increases Nidalee's Movement Speed by 10% for 2 seconds, increased to 30% toward visible enemy champions within 1400 range.<br><br>Hitting champions or monsters with Javelin Toss or Bushwhack triggers a <font color='#FFF673'>Hunt</font>, granting <font color='#ee91d7'>True Sight</font> of them for 4 seconds. During this time, Nidalee gains 10% Movement Speed (increased to 30% toward the <font color='#FFF673'>Hunted</font> target) and her Takedown and Pounce are enhanced against them.",
                        "nidalee_passive"),
                new Champion.Spell("Javelin Toss / Takedown", "50/60/70/80/90", "6",
                        "In human form, Nidalee throws a spiked javelin at her target that gains damage as it flies.  As a cougar, her next attack will attempt to fatally wound her target, dealing more damage the less life they have.",
                        "<span class=\\\"size18 colorFF9900\\\">Human: </span>Nidalee throws her javelin, dealing {{ e1 }} <span class=\\\"color99FF99\\\">(+{{ a2 }})</span> magic damage. If it exceeds her basic attack range, it gains damage based on distance flown, up to a potential {{ e2 }} <span class=\\\"color99FF99\\\">(+{{ a1 }})</span> total damage.<br /><br /><span class=\\\"size18 colorFF9900\\\">Cougar: </span>Nidalee's next attack deals additional damage, greatly increased on low health targets.",
                        "nidalee_spell_javelin_toss"),
                new Champion.Spell("Bushwhack / Pounce", "40/45/50/55/60", "13/12/11/10/9",
                        "In human form, Nidalee lays a trap for unwary opponents that, when sprung, damages and reveals its target. As a cougar, she jumps in a direction, dealing damage in an area where she lands.",
                        "<span class=\\\"size18 colorFF9900\\\">Human: </span>Nidalee places an invisible trap that lasts for 2 minutes. The trap triggers when an enemy walks over it, revealing the victim and bleeding them for {{ e7 }} <span class=\\\"color99FF99\\\">(+{{ a2 }})</span> magic damage over 4 seconds.<br /><br /><span class=\\\"colorFFFFFF\\\">{{ f4 }}</span> traps may be active at once. (Maximum traps increases at level 6, 11 and 16)<br /><br /><span class=\\\"size18 colorFF9900\\\">Cougar: </span>Nidalee lunges in target direction, dealing damage to nearby enemies.",
                        "nidalee_spell_bushwhack"),
                new Champion.Spell("Primal Surge / Swipe", "70/80/90/100/110", "10/9.5/9/8.5/8",
                        "In human form, Nidalee channels the spirit of the cougar to heal her allies and imbue them with Attack Speed for a short duration. As a cougar, she claws in a direction, dealing damage to enemies in front of her.",
                        "<span class=\\\"size18 colorFF9900\\\">Human: </span>Nidalee heals target ally champion for {{ e1 }} <span class=\\\"color99FF99\\\">(+{{ a2 }})</span> to {{ e2 }} <span class=\\\"color99FF99\\\">(+{{ f3 }})</span> based on their missing health and grants them {{ e4 }}% Attack Speed for 7 seconds.<br /><br /><span class=\\\"size18 colorFF9900\\\">Cougar: </span>Nidalee claws at enemies in target direction.",
                        "nidalee_spell_primal_surge"),
                new Champion.Spell("Aspect Of The Cougar", "60/75/90/105/120", "12",
                        "Nidalee transforms into a cougar, gaining new abilities.",
                        "<span class=\"size18 colorFF9900\">Human: </span>Nidalee transforms into a vicious cougar with the basic abilities Takedown, Pounce, and Swipe.<br /><br /><span class=\"size18 colorFF9900\">Cougar: </span>Nidalee transforms back into human form. While in human form, triggering a <span class=\"colorFFF673\">Hunt</span> resets the cooldown of Aspect of the Cougar.",
                        "nidalee_spell_aspect_of_the_cougar")),
                getSkins("nidalee"));

        this.dataSource.add(anivia);
        this.dataSource.add(lux);
        this.dataSource.add(nidalee);
    }


    public List<Champion.Skin> getSkins(String name) {
        List<Champion.Skin> skins = new ArrayList<>();

        for (int i = 0; i <= 8; i++) {
            skins.add(new Champion.Skin(name.concat("_").concat(String.valueOf(i))));
        }

        return skins;
    }
}
