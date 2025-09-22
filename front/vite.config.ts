import { defineConfig } from "vite";
import react from "@vitejs/plugin-react-swc";
import path from "path";
import { componentTagger } from "lovable-tagger";

// https://vitejs.dev/config/
export default defineConfig(({ mode }) => ({
  server: {
      https: false, // Ważne - wyłącz HTTPS
      proxy: {
        '/api': {
          target: 'http://3.71.255.220:8080',
          changeOrigin: true,
          secure: false,
          rewrite: (path) => path // Nie zmieniaj ścieżki
        }
      }
    },
  plugins: [
    react(),
    mode === 'development' &&
    componentTagger(),
  ].filter(Boolean),
  resolve: {
    alias: {
      "@": path.resolve(__dirname, "./src"),
    },
  },
}));
