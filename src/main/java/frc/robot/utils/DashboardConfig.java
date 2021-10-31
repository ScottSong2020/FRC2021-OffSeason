package frc.robot.utils;

import java.util.*;

public class DashboardConfig
{
    private EnumSet<DashboardKey> enabledDashboardKeys;

    /**
     * By default, all Keys are enabled
     */
    public DashboardConfig()
    {
        this.enabledDashboardKeys = EnumSet.allOf(DashboardKey.class);
    }

    public boolean isEnabled(DashboardKey key)
    {
        return this.enabledDashboardKeys.contains(key);
    }

    public DashboardConfig addEnabled(DashboardKey... enabled)
    {
        this.enabledDashboardKeys.addAll(List.of(enabled));
        return this;
    }

    public DashboardConfig onlyEnabled(DashboardKey... enabled)
    {
        this.enabledDashboardKeys = EnumSet.copyOf(List.of(enabled));
        return this;
    }

    public DashboardConfig addDisabled(DashboardKey... disabled)
    {
        this.enabledDashboardKeys.removeIf(d -> List.of(disabled).contains(d));
        return this;
    }
}
