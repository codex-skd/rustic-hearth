# Changelog

## 0.0.0-beta.1 (sin publicar)

- Fork de Rustic Revived 1.0.0 (NadienDev, MIT; a su vez port de Rustic de cadaverous-eris y the-realest-stu) renombrado a **Rustic Hearth**: mod id y namespace `rustic_hearth`, paquete `com.skd.rustichearth`, NeoForge 21.1.259. Sin cambios de contenido respecto a Revived.
- Se eliminan las integraciones opcionales con CraftTweaker, KubeJS, Dynamic Trees e InvTweaks (se conservan JEI y Quark). Desaparecen los bloques de hojas dinámicas de Dynamic Trees y la opción de config `enableDynamicTreesCompat`.
- Icono propio (`icon.png`) y `docs/IDS_RUSTIC_HEARTH.md`: tabla de equivalencias de los 66 ids `rustic:*` que usan las plantillas de Ancient Warfare 2 (51 iguales, 10 con mapeo, 5 de tile entity descartables), con un script de comprobación.
- `build` y `runServer` verificados (el servidor arranca limpio). **No probado in-game**: render, bloques, máquinas de alquimia, cultivos y colmenas.

## [0.0.0-beta.2] - 2026-10-29

### Changed

- **Tokens de CurseForge**: el token de subida y la clave Core ya no se guardan en `docs/curseforge/project_vars.md`; se leen de las variables de entorno de usuario `API_MOD_UPLOAD_CURSEFORGE` y `API_MOD_GET_CURSEFORGE`. Los scripts de subida y consulta se han adaptado y la documentación se ha actualizado.
- **Sin cambios en el mod**: solo documentación y tooling. Versión **exenta de subida a CurseForge** (no hay JAR nuevo que publicar); se versiona por ser un cambio de proceso importante.
