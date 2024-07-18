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
     * The Is destroy on dismiss.
     */
    private boolean isDestroyOnDismiss;
    /**
     * The Load name.
     */
    private String loadName;

    /**
     * Sets view model.
     *
     * @param viewModel the view model
     */
    public LoadingConfig setViewModel(boolean viewModel) {
        this.isViewModel = viewModel;
        return this;
    }

    /**
     * Sets can back cancel.
     *
     * @param canBackCancel the can back cancel
     */
    public LoadingConfig setCanBackCancel(boolean canBackCancel) {
        this.canBackCancel = canBackCancel;
        return this;
    }

    /**
     * Sets can out side cancel.
     *
     * @param canOutSideCancel the can out side cancel
     */
    public LoadingConfig setCanOutSideCancel(boolean canOutSideCancel) {
        this.canOutSideCancel = canOutSideCancel;
        return this;
    }

    /**
     * Sets has blur bg.
     *
     * @param hasBlurBg the has blur bg
     */
    public LoadingConfig setHasBlurBg(boolean hasBlurBg) {
        this.hasBlurBg = hasBlurBg;
        return this;
    }

    /**
     * Sets has shadow.
     *
     * @param hasShadow the has shadow
     */
    public LoadingConfig setHasShadow(boolean hasShadow) {
        this.hasShadow = hasShadow;
        return this;
    }

    /**
     * Sets destroy on dismiss.
     *
     * @param destroyOnDismiss the destroy on dismiss
     */
    public LoadingConfig setDestroyOnDismiss(boolean destroyOnDismiss) {
        isDestroyOnDismiss = destroyOnDismiss;
        return this;
    }

    /**
     * Sets load name.
     *
     * @param loadName the load name
     */
    public LoadingConfig setLoadName(String loadName) {
        this.loadName = loadName;
        return this;
    }

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
     * Is destroy on dismiss boolean.
     *
     * @return the boolean
     */
    public boolean isDestroyOnDismiss() {
        return isDestroyOnDismiss;
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
     * @param isViewModel        the is view model
     * @param canBackCancel      the can back cancel
     * @param canOutSideCancel   the can out side cancel
     * @param hasBlurBg          the has blur bg
     * @param hasShadow          the has shadow
     * @param isDestroyOnDismiss the is destroy on dismiss
     * @param loadName           the load name
     */
    public LoadingConfig(boolean isViewModel, boolean canBackCancel, boolean canOutSideCancel, boolean hasBlurBg, boolean hasShadow, boolean isDestroyOnDismiss, String loadName) {
        this.isViewModel = isViewModel;
        this.canBackCancel = canBackCancel;
        this.canOutSideCancel = canOutSideCancel;
        this.hasBlurBg = hasBlurBg;
        this.hasShadow = hasShadow;
        this.isDestroyOnDismiss = isDestroyOnDismiss;
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
         * The Is destroy on dismiss.
         */
        private boolean isDestroyOnDismiss;
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
         * Is destroy on dismiss config builder.
         *
         * @param isDestroyOnDismiss the is destroy on dismiss
         * @return the config builder
         */
        public ConfigBuilder isDestroyOnDismiss(boolean isDestroyOnDismiss) {
            this.isDestroyOnDismiss = isDestroyOnDismiss;
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
            return new LoadingConfig(this.isViewModel, this.canBackCancel, this.canOutSideCancel, this.hasBlurBg, this.hasShadow, this.isDestroyOnDismiss, this.loadName);
        }
    }
}
