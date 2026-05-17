package dev.crysscoder.customenchanttable;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;
import dev.crysscoder.customenchanttable.command.GiveCommand;
import dev.crysscoder.customenchanttable.data.ConfigData;
import dev.crysscoder.customenchanttable.event.EnchantTableOpenListener;
import dev.crysscoder.customenchanttable.event.InventoryCloseListener;
import dev.crysscoder.customenchanttable.gui.ClickService;
import dev.crysscoder.customenchanttable.gui.inv.GuideMenu;
import dev.crysscoder.customenchanttable.gui.inv.main.EnchantLevelManager;
import dev.crysscoder.customenchanttable.gui.inv.main.EnchantManager;
import dev.crysscoder.customenchanttable.gui.inv.main.item.ItemMenuManager;
import dev.crysscoder.customenchanttable.gui.inv.main.item.MenuManager;
import dev.crysscoder.customenchanttable.manager.ConfigManager;
import dev.crysscoder.customenchanttable.manager.ItemManager;
import dev.crysscoder.customenchanttable.util.BookshelfPowerCalculator;

@Getter
public final class CustomEnchantingTable extends JavaPlugin {

    @Getter
    public static CustomEnchantingTable instance;

    private GuideMenu guideMenu;
    private EnchantLevelManager enchantLevelManager;
    private EnchantManager enchantManager;
    private ItemMenuManager itemMenuManager;
    private MenuManager menuManager;


    @Override
    public void onEnable() {
        instance = this;
        final ConfigManager configManager = new ConfigManager(this);
         final ConfigData configData = configManager.getConfigData();
        enchantLevelManager = new EnchantLevelManager(configData);
        enchantManager = new EnchantManager();
        itemMenuManager = new ItemMenuManager();
        menuManager = new MenuManager();


        this.guideMenu = new GuideMenu(configData, menuManager);

        final ItemManager itemManager = new ItemManager();
        final BookshelfPowerCalculator calculator = new BookshelfPowerCalculator();



        getServer().getPluginManager().registerEvents(new EnchantTableOpenListener(calculator, this, enchantLevelManager, configData, itemMenuManager, menuManager), this);
        getServer().getPluginManager().registerEvents(new ClickService(), this);
        getServer().getPluginManager().registerEvents(new InventoryCloseListener(itemMenuManager, menuManager), this);
        getServer().getPluginManager().registerEvents(guideMenu, this);
        getCommand("giveTable").setExecutor(new GiveCommand(itemManager));


    }

    @Override
    public void onDisable() {
    }

}
