/// <reference types="vite/client" />

// shims-vue.d.ts
declare module '*.vue' {
    import type {DefineComponent} from 'vue';
    const component: DefineComponent<{}, {}, any>;
    export default component;
}
