package cn.com.shadowless.baseobserver;

/**
 * 加载配置类
 *
 * @author sHadowLess
 */
public class LoadingConfig {
    /**
     * 是否为视图模式
     */
    private boolean isViewModel;
    /**
     * 是否可以通过返回键取消
     */
    private boolean canBackCancel;
    /**
     * 是否可以通过点击外部取消
     */
    private boolean canOutSideCancel;
    /**
     * 是否有模糊背景
     */
    private boolean hasBlurBg;
    /**
     * 是否有阴影背景
     */
    private boolean hasShadow;
    /**
     * 是否在消失时销毁
     */
    private boolean isDestroyOnDismiss;
    /**
     * 加载名称
     */
    private String loadName;

    /**
     * 设置是否为视图模式
     *
     * @param viewModel 是否为视图模式
     * @return LoadingConfig实例
     */
    public LoadingConfig setViewModel(boolean viewModel) {
        this.isViewModel = viewModel;
        return this;
    }

    /**
     * 设置是否可以通过返回键取消
     *
     * @param canBackCancel 是否可以通过返回键取消
     * @return LoadingConfig实例
     */
    public LoadingConfig setCanBackCancel(boolean canBackCancel) {
        this.canBackCancel = canBackCancel;
        return this;
    }

    /**
     * 设置是否可以通过点击外部取消
     *
     * @param canOutSideCancel 是否可以通过点击外部取消
     * @return LoadingConfig实例
     */
    public LoadingConfig setCanOutSideCancel(boolean canOutSideCancel) {
        this.canOutSideCancel = canOutSideCancel;
        return this;
    }

    /**
     * 设置是否有模糊背景
     *
     * @param hasBlurBg 是否有模糊背景
     * @return LoadingConfig实例
     */
    public LoadingConfig setHasBlurBg(boolean hasBlurBg) {
        this.hasBlurBg = hasBlurBg;
        return this;
    }

    /**
     * 设置是否有阴影背景
     *
     * @param hasShadow 是否有阴影背景
     * @return LoadingConfig实例
     */
    public LoadingConfig setHasShadow(boolean hasShadow) {
        this.hasShadow = hasShadow;
        return this;
    }

    /**
     * 设置是否在消失时销毁
     *
     * @param destroyOnDismiss 是否在消失时销毁
     * @return LoadingConfig实例
     */
    public LoadingConfig setDestroyOnDismiss(boolean destroyOnDismiss) {
        isDestroyOnDismiss = destroyOnDismiss;
        return this;
    }

    /**
     * 设置加载名称
     *
     * @param loadName 加载名称
     * @return LoadingConfig实例
     */
    public LoadingConfig setLoadName(String loadName) {
        this.loadName = loadName;
        return this;
    }

    /**
     * 获取是否为视图模式
     *
     * @return 是否为视图模式
     */
    public boolean isViewModel() {
        return isViewModel;
    }

    /**
     * 获取是否可以通过返回键取消
     *
     * @return 是否可以通过返回键取消
     */
    public boolean isCanBackCancel() {
        return canBackCancel;
    }

    /**
     * 获取是否可以通过点击外部取消
     *
     * @return 是否可以通过点击外部取消
     */
    public boolean isCanOutSideCancel() {
        return canOutSideCancel;
    }

    /**
     * 获取是否有模糊背景
     *
     * @return 是否有模糊背景
     */
    public boolean isHasBlurBg() {
        return hasBlurBg;
    }

    /**
     * 获取是否有阴影背景
     *
     * @return 是否有阴影背景
     */
    public boolean isHasShadow() {
        return hasShadow;
    }

    /**
     * 获取是否在消失时销毁
     *
     * @return 是否在消失时销毁
     */
    public boolean isDestroyOnDismiss() {
        return isDestroyOnDismiss;
    }

    /**
     * 获取加载名称
     *
     * @return 加载名称
     */
    public String getLoadName() {
        return loadName;
    }

    /**
     * 构造函数
     *
     * @param isViewModel        是否为视图模式
     * @param canBackCancel      是否可以通过返回键取消
     * @param canOutSideCancel   是否可以通过点击外部取消
     * @param hasBlurBg          是否有模糊背景
     * @param hasShadow          是否有阴影背景
     * @param isDestroyOnDismiss 是否在消失时销毁
     * @param loadName           加载名称
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
     * 获取构造器
     *
     * @return ConfigBuilder构造器
     */
    public static ConfigBuilder builder() {
        return new ConfigBuilder();
    }

    /**
     * 构造器实体类
     */
    public static class ConfigBuilder {
        /**
         * 是否为视图模式
         */
        private boolean isViewModel;
        /**
         * 是否可以通过返回键取消
         */
        private boolean canBackCancel;
        /**
         * 是否可以通过点击外部取消
         */
        private boolean canOutSideCancel;
        /**
         * 是否有模糊背景
         */
        private boolean hasBlurBg;
        /**
         * 是否有阴影背景
         */
        private boolean hasShadow;

        /**
         * 是否在消失时销毁
         */
        private boolean isDestroyOnDismiss;
        /**
         * 加载名称
         */
        private String loadName;

        /**
         * 设置是否为视图模式
         *
         * @param isViewModel 是否为视图模式
         * @return ConfigBuilder构造器
         */
        public ConfigBuilder isViewModel(boolean isViewModel) {
            this.isViewModel = isViewModel;
            return this;
        }

        /**
         * 设置是否在消失时销毁
         *
         * @param isDestroyOnDismiss 是否在消失时销毁
         * @return ConfigBuilder构造器
         */
        public ConfigBuilder isDestroyOnDismiss(boolean isDestroyOnDismiss) {
            this.isDestroyOnDismiss = isDestroyOnDismiss;
            return this;
        }


        /**
         * 设置是否可以通过返回键取消
         *
         * @param canBackCancel 是否可以通过返回键取消
         * @return ConfigBuilder构造器
         */
        public ConfigBuilder canBackCancel(boolean canBackCancel) {
            this.canBackCancel = canBackCancel;
            return this;
        }

        /**
         * 设置是否可以通过点击外部取消
         *
         * @param canOutSideCancel 是否可以通过点击外部取消
         * @return ConfigBuilder构造器
         */
        public ConfigBuilder canOutSideCancel(boolean canOutSideCancel) {
            this.canOutSideCancel = canOutSideCancel;
            return this;
        }

        /**
         * 设置是否有模糊背景
         *
         * @param hasBlurBg 是否有模糊背景
         * @return ConfigBuilder构造器
         */
        public ConfigBuilder hasBlurBg(boolean hasBlurBg) {
            this.hasBlurBg = hasBlurBg;
            return this;
        }

        /**
         * 设置是否有阴影背景
         *
         * @param hasShadow 是否有阴影背景
         * @return ConfigBuilder构造器
         */
        public ConfigBuilder hasShadow(boolean hasShadow) {
            this.hasShadow = hasShadow;
            return this;
        }

        /**
         * 设置加载名称
         *
         * @param loadName 加载名称
         * @return ConfigBuilder构造器
         */
        public ConfigBuilder loadName(String loadName) {
            this.loadName = loadName;
            return this;
        }

        /**
         * 构建LoadingConfig实例
         *
         * @return LoadingConfig实例
         */
        public LoadingConfig build() {
            return new LoadingConfig(this.isViewModel, this.canBackCancel, this.canOutSideCancel, this.hasBlurBg, this.hasShadow, this.isDestroyOnDismiss, this.loadName);
        }
    }
}