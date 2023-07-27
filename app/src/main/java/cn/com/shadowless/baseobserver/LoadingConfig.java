package cn.com.shadowless.baseobserver;

/**
 * The type Loading view bean.
 *
 * @author sHadowLess
 */
public class LoadingConfig {
    /**
     * The Is view model.
     */
    private final boolean isViewModel;
    /**
     * The Can back cancel.
     */
    private final boolean canBackCancel;
    /**
     * The Can out side cancel.
     */
    private final boolean canOutSideCancel;
    /**
     * The Has blur bg.
     */
    private final boolean hasBlurBg;
    /**
     * The Has shadow.
     */
    private final boolean hasShadow;
    /**
     * The Can cancel.
     */
    private final boolean canCancel;
    /**
     * The Is smart dismiss.
     */
    private final boolean isSmartDismiss;
    /**
     * The Load name.
     */
    private final String loadName;

    /**
     * Is view model boolean.
     *
     * @return the boolean
     */
    public boolean isViewModel() {
        return isViewModel;
    }

    /**
     * Is can back cancel boolean.
     *
     * @return the boolean
     */
    public boolean isCanBackCancel() {
        return canBackCancel;
    }

    /**
     * Is can out side cancel boolean.
     *
     * @return the boolean
     */
    public boolean isCanOutSideCancel() {
        return canOutSideCancel;
    }

    /**
     * Is has blur bg boolean.
     *
     * @return the boolean
     */
    public boolean isHasBlurBg() {
        return hasBlurBg;
    }

    /**
     * Is has shadow boolean.
     *
     * @return the boolean
     */
    public boolean isHasShadow() {
        return hasShadow;
    }

    /**
     * Is can cancel boolean.
     *
     * @return the boolean
     */
    public boolean isCanCancel() {
        return canCancel;
    }

    /**
     * Is smart dismiss boolean.
     *
     * @return the boolean
     */
    public boolean isSmartDismiss() {
        return isSmartDismiss;
    }

    /**
     * Gets load name.
     *
     * @return the load name
     */
    public String getLoadName() {
        return loadName;
    }

    /**
     * 构造
     *
     * @param isViewModel      the is view model
     * @param canBackCancel    the can back cancel
     * @param canOutSideCancel the can out side cancel
     * @param hasBlurBg        the has blur bg
     * @param hasShadow        the has shadow
     * @param canCancel        the can cancel
     * @param isSmartDismiss   the is smart dismiss
     * @param loadName         the load name
     */
    public LoadingConfig(boolean isViewModel, boolean canBackCancel, boolean canOutSideCancel, boolean hasBlurBg, boolean hasShadow, boolean canCancel, boolean isSmartDismiss, String loadName) {
        this.isViewModel = isViewModel;
        this.canBackCancel = canBackCancel;
        this.canOutSideCancel = canOutSideCancel;
        this.hasBlurBg = hasBlurBg;
        this.hasShadow = hasShadow;
        this.canCancel = canCancel;
        this.isSmartDismiss = isSmartDismiss;
        this.loadName = loadName;
    }

    /**
     * 构造者
     *
     * @return the net utils . net utils builder
     */
    public static ConfigBuilder builder() {
        return new ConfigBuilder();
    }

    /**
     * 构造者实体
     */
    public static class ConfigBuilder {
        /**
         * The Is view model.
         */
        private boolean isViewModel;
        /**
         * The Can back cancel.
         */
        private boolean canBackCancel;
        /**
         * The Can out side cancel.
         */
        private boolean canOutSideCancel;
        /**
         * The Has blur bg.
         */
        private boolean hasBlurBg;
        /**
         * The Has shadow.
         */
        private boolean hasShadow;
        /**
         * The Can cancel.
         */
        private boolean canCancel;
        /**
         * The Is smart dismiss.
         */
        private boolean isSmartDismiss;
        /**
         * The Load name.
         */
        private String loadName;

        /**
         * Is view model config builder.
         *
         * @param isViewModel the is view model
         * @return the config builder
         */
        public ConfigBuilder isViewModel(boolean isViewModel) {
            this.isViewModel = isViewModel;
            return this;
        }

        /**
         * Can back cancel config builder.
         *
         * @param canBackCancel the can back cancel
         * @return the config builder
         */
        public ConfigBuilder canBackCancel(boolean canBackCancel) {
            this.canBackCancel = canBackCancel;
            return this;
        }

        /**
         * Can out side cancel config builder.
         *
         * @param canOutSideCancel the can out side cancel
         * @return the config builder
         */
        public ConfigBuilder canOutSideCancel(boolean canOutSideCancel) {
            this.canOutSideCancel = canOutSideCancel;
            return this;
        }

        /**
         * Has blur bg config builder.
         *
         * @param hasBlurBg the has blur bg
         * @return the config builder
         */
        public ConfigBuilder hasBlurBg(boolean hasBlurBg) {
            this.hasBlurBg = hasBlurBg;
            return this;
        }

        /**
         * Has shadow config builder.
         *
         * @param hasShadow the has shadow
         * @return the config builder
         */
        public ConfigBuilder hasShadow(boolean hasShadow) {
            this.hasShadow = hasShadow;
            return this;
        }

        /**
         * Can cancel config builder.
         *
         * @param canCancel the can cancel
         * @return the config builder
         */
        public ConfigBuilder canCancel(boolean canCancel) {
            this.canCancel = canCancel;
            return this;
        }

        /**
         * Is smart dismiss config builder.
         *
         * @param isSmartDismiss the is smart dismiss
         * @return the config builder
         */
        public ConfigBuilder isSmartDismiss(boolean isSmartDismiss) {
            this.isSmartDismiss = isSmartDismiss;
            return this;
        }

        /**
         * Load name config builder.
         *
         * @param loadName the load name
         * @return the config builder
         */
        public ConfigBuilder loadName(String loadName) {
            this.loadName = loadName;
            return this;
        }

        /**
         * Build loading config.
         *
         * @return the loading config
         */
        public LoadingConfig build() {
            return new LoadingConfig(this.isViewModel, this.canBackCancel, this.canOutSideCancel, this.hasBlurBg, this.hasShadow, this.canCancel, this.isSmartDismiss, this.loadName);
        }
    }
}
